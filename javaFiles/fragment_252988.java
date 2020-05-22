import java.applet.Applet;
import java.applet.AppletContext;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Enumeration;
import java.util.StringTokenizer;
import java.util.Vector;

public class ProScroll extends Applet
  implements Runnable
{
  private Thread thread;
  private Image image;
  private int scrollLength;
  private int scrolled;
  private int speed = 10;
  private int imgsWidth;
  private URL url;
  private String target;
  private Color bgColor;

  public void init()
  {
    int i = 12; int j = 0;

    String str2 = getParameter("TEXT");
    String str3 = getParameter("TEXTURL");

    if ((str2 == null) && (str3 == null)) {
      str2 = "No TEXT or TEXTURL parameter specified";
    }
    if (str3 != null)
    {
      localObject = new StringBuffer();
      try
      {
        InputStream localInputStream = new URL(str3)
          .openConnection().getInputStream();
        while (true)
        {
          int k = localInputStream.read();
          if (k == -1) break;
          if (k != 10) {
            if (k == 9) { ((StringBuffer)localObject).append(' '); continue; }
            ((StringBuffer)localObject).append((char)k);
          }
        }
        localInputStream.close();

        str2 = ((StringBuffer)localObject).toString();
      }
      catch (Exception localException1)
      {
        if (str2 == null) {
          str2 = "Error loading text from URL: " + localException1;
        }
      }
    }
    String str1 = getParameter("FONT");
    if (str1 == null) str1 = "TimesRoman";

    this.target = getParameter("TARGET");
    if (this.target == null) this.target = "_self";

    try
    {
      i = Integer.parseInt(getParameter("SIZE"));
    }
    catch (Exception localException2)
    {
    }

    Object localObject = getParameter("STYLE");
    if ("bold".equals(localObject)) j = 1;
    else if ("italic".equals(localObject)) j = 2;
    else if ("bolditalic".equals(localObject)) j = 3;

    String str4 = getParameter("SPEED");
    if ("slow".equals(str4)) this.speed = 20;
    else if ("medium".equals(str4)) this.speed = 15; else {
      this.speed = 10;
    }
    try
    {
      this.url = new URL(getDocumentBase(), getParameter("URL"));
    }
    catch (Exception localException3)
    {
    }

    this.bgColor = parseColorName(getParameter("BGCOLOR"), Color.black);

    Enumeration localEnumeration = parseAndLoadImages(getParameter("IMAGES"));

    Font localFont = new Font(str1, j, i);

    FontMetrics localFontMetrics = getToolkit().getFontMetrics(localFont);

    this.image = createImage(localFontMetrics.stringWidth(str2) + this.imgsWidth + size().width, size().height);

    this.scrolled = (-size().width);

    parseAndDrawText(this.image.getGraphics(), str2, localFontMetrics, localFont, localEnumeration);
  }

  private void parseAndDrawText(Graphics paramGraphics, String paramString, FontMetrics paramFontMetrics, Font paramFont, Enumeration paramEnumeration)
  {
    paramGraphics.setFont(paramFont);
    paramGraphics.setColor(this.bgColor);
    paramGraphics.fillRect(0, 0, this.image.getWidth(this), this.image.getHeight(this));
    paramGraphics.setColor(Color.white);

    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0; int j = 0;

    for (int k = 0; k < paramString.length(); k++)
    {
      char c = paramString.charAt(k);

      if ((c == '#') && (j == 0))
      {
        if (i != 0)
        {
          paramGraphics.setColor(parseColorName(localStringBuffer.toString(), Color.white));
          localStringBuffer.setLength(0);
          i = 0;
        }
        else
        {
          i = 1;
        }
      }
      else if ((c == '$') && (i == 0) && (j == 0))
      {
        try
        {
          Image localImage = (Image)paramEnumeration.nextElement();
          paramGraphics.drawImage(localImage, this.scrollLength, 0, this);
          this.scrollLength += localImage.getWidth(this);
        }
        catch (Exception localException)
        {
        }
      }
      else if ((c == '/') && (j == 0))
      {
        j = 1;
      }
      else if (i != 0)
      {
        localStringBuffer.append(c);
      }
      else
      {
        if (j == 1) j = 0;
        paramGraphics.drawString(String.valueOf(c), this.scrollLength, paramFontMetrics.getAscent());
        this.scrollLength += paramFontMetrics.charWidth(c);
      }
    }
  }

  private Color parseColorName(String paramString, Color paramColor)
  {
    if ("red".equals(paramString)) return Color.red;
    if ("green".equals(paramString)) return Color.green;
    if ("blue".equals(paramString)) return Color.blue;
    if ("yellow".equals(paramString)) return Color.yellow;
    if ("orange".equals(paramString)) return Color.orange;
    if ("white".equals(paramString)) return Color.white;
    if ("lightGray".equals(paramString)) return Color.lightGray;
    if ("gray".equals(paramString)) return Color.gray;
    if ("darkGray".equals(paramString)) return Color.darkGray;
    if ("black".equals(paramString)) return Color.black;
    if ("cyan".equals(paramString)) return Color.cyan;
    if ("magenta".equals(paramString)) return Color.magenta;
    if ("pink".equals(paramString)) return Color.pink;
    return paramColor;
  }

  private Enumeration parseAndLoadImages(String paramString)
  {
    if (paramString == null) return null;

    int i = 0;
    Vector localVector = new Vector();
    StringTokenizer localStringTokenizer = new StringTokenizer(paramString);
    MediaTracker localMediaTracker = new MediaTracker(this);

    while (localStringTokenizer.hasMoreTokens())
    {
      try
      {
        Image localImage = getImage(new URL(getDocumentBase(), localStringTokenizer.nextToken()));
        localVector.addElement(localImage);
        localMediaTracker.addImage(localImage, i);
        localMediaTracker.waitForID(i++);
        this.imgsWidth += localImage.getWidth(this);
      }
      catch (Exception localException)
      {
      }
    }

    return localVector.elements();
  }

  public void start()
  {
    this.thread = new Thread(this);
    this.thread.start();
  }

  public void stop()
  {
    this.thread = null;
    this.scrolled = (-size().width);
  }

  public void run()
  {
    while (Thread.currentThread() == this.thread)
    {
      long l = System.currentTimeMillis();

      if (++this.scrolled > this.scrollLength) this.scrolled = (-size().width);

      repaint();
      try
      {
        Thread.sleep(Math.max(this.speed - (System.currentTimeMillis() - l), 0L));
      }
      catch (InterruptedException localInterruptedException)
      {
      }
    }
  }

  public boolean mouseEnter(Event paramEvent, int paramInt1, int paramInt2)
  {
    if (this.url != null) getAppletContext().showStatus("Link: " + this.url.toString());
    return true;
  }

  public boolean mouseExit(Event paramEvent, int paramInt1, int paramInt2)
  {
    if (this.url != null) getAppletContext().showStatus("");
    return true;
  }

  public boolean mouseUp(Event paramEvent, int paramInt1, int paramInt2)
  {
    if (this.url != null) getAppletContext().showDocument(this.url, this.target);
    return true;
  }

  public void update(Graphics paramGraphics)
  {
    paramGraphics.setColor(this.bgColor);
    if (this.scrolled < 0)
    {
      paramGraphics.setColor(this.bgColor);
      paramGraphics.fillRect(0, 0, -this.scrolled, size().height);
    }
    paramGraphics.drawImage(this.image, -this.scrolled, 0, this);
  }

  public void paint(Graphics paramGraphics)
  {
    update(paramGraphics);
  }

  public String getAppletInfo()
  {
    return "ProScroll version 2.3 by Slava Pestov";
  }
}