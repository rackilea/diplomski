import java.awt.*;
import java.io.*;
import java.net.URL;
import javafx.embed.swing.JFXPanel;
import javafx.application.Platform;
import javafx.concurrent.Worker.State;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.web.*;
import javax.swing.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;

/**
 Note using the browser might require setting the properties
 - http.proxyHost
 - http.proxyPort
 e.g. -Dhttp.proxyHost=webcache.mydomain.com -Dhttp.proxyPort=8080
*/

public class JavaFX_Html_Loader extends JPanel
{
  private final int PANEL_WIDTH_INT=1130;
  private final int PANEL_HEIGHT_INT=840;
  private JFXPanel browserFxPanel;
  private Pane browser;
  WebView view;
  WebEngine eng;
  static String Url,Urls[]=new String[]{"https://www.iplocation.net/?query=63.149.124.133"};
  static boolean Show_Frame_B=true;
//  static boolean Show_Frame_B=false;
  StringBuffer Str_Buf;

  public JavaFX_Html_Loader(String Url)
  {
    this.Url=Url;
    init();
    setURL(Url);
  }

  void init()
  {
    if (Show_Frame_B)
    {
      FlowLayout FL=new FlowLayout();
      FL.setHgap(0);
      FL.setVgap(0);
      setLayout(FL);
    }
    setPreferredSize(new Dimension(PANEL_WIDTH_INT,PANEL_HEIGHT_INT));
    browserFxPanel=new JFXPanel();
    add(browserFxPanel);
    Platform.runLater(new Runnable() { public void run() { createScene(); } });
  }

  public void setURL(final String Url)
  {
    Platform.runLater(new Runnable()
    {
      public void run()
      {
        if (new File(Url).exists()) setURL(new File(Url));
        else eng.load((Url.startsWith("http://") || Url.startsWith("https://"))?Url:"http://"+Url);
//        browserFxPanel.setEnabled(false);
      }
    });
  }

  public void setURL(final URL Url)
  {
    Platform.runLater(new Runnable()
    {
      public void run()
      {
        try { eng.load(Url.toString()); }
        catch (Exception e) { e.printStackTrace(); }
      }
    });
  }

  public void setURL(final File file)
  {
    Platform.runLater(new Runnable()
    {
      public void run()
      {
        try { eng.load(file.toURI().toURL().toString()); }
        catch (Exception e) { e.printStackTrace(); }
      }
    });
  }

  private void createScene()
  {
    browser=createBrowser();
    browserFxPanel.setScene(new Scene(browser));
  }

  private Pane createBrowser()
  {
    view=new WebView();
    if (Show_Frame_B)
    {
      Double widthDouble=new Integer(PANEL_WIDTH_INT).doubleValue();
      Double heightDouble=new Integer(PANEL_HEIGHT_INT).doubleValue();
      view.setMinSize(widthDouble,heightDouble);
      view.setPrefSize(widthDouble,heightDouble);
    }
    eng=view.getEngine();
    eng.getLoadWorker().stateProperty().addListener((obs,oldValue,newValue)->            // addListener()
    {
      System.out.println(newValue);
      if (newValue==State.SUCCEEDED)
      {
        Str_Buf=new StringBuffer();
//        System.out.println("finished loading");
        try
        {
          TransformerFactory transformerFactory=TransformerFactory.newInstance();
          Transformer transformer=transformerFactory.newTransformer();
          StringWriter stringWriter=new StringWriter();
          transformer.transform(new DOMSource(eng.getDocument()),new StreamResult(stringWriter));

          Str_Buf.append(stringWriter.getBuffer());
          Out(Str_Buf.toString());
          if (Str_Buf.toString().endsWith("</BODY></HTML>")) System.exit(0);
        }
        catch (Exception e) { e.printStackTrace(); }
      }
    });
    GridPane grid=new GridPane();
    grid.getChildren().addAll(view);
    return grid;
  }

  public static void out(String message) { System.out.print(message); }   
  public static void Out(String message) { System.out.println(message); }

  public static void main(String[] args)
  {
    final JavaFX_Html_Loader demo=new JavaFX_Html_Loader(Urls[0]);

    if (Show_Frame_B)
    {
      SwingUtilities.invokeLater(new Runnable()
      {
        public void run()
        {
          JFrame frame=new JFrame("JavaFX 2.2 in Swing");
          frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          frame.add(demo);
          frame.pack();
          frame.setLocationRelativeTo(null);
          frame.setVisible(true);
        }
      });
    }

  }
}