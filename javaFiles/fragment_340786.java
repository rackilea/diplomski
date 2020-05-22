import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.font.TextAttribute;
import java.awt.geom.Area;
import java.awt.geom.RoundRectangle2D;
import java.util.Collections;
import javax.swing.*;
import javax.swing.border.AbstractBorder;

public class PopupTryout2 {
  public static void main(String[] args) {
    JFrame frm = new JFrame("Popup test");
    JButton button = new JButton("Test");
    JPanel p = new JPanel();
    p.add(button);
    frm.add(p, BorderLayout.SOUTH);
    frm.add(new JScrollPane(new JTextArea()));

    JPanel hintPanel = new JPanel();
    hintPanel.add(new JLabel("This button has no function ;)"));
    hintPanel.setOpaque(false);
    JLabel closeBtn = new JLabel("Close");
    closeBtn.setForeground(Color.BLUE);
    closeBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    hintPanel.add(closeBtn);
    hintPanel.setBorder(new TextBubbleBorder(Color.BLACK, 1, 6, 8, false));
    hintPanel.setOpaque(false);

    frm.setSize(600, 500);
    frm.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    frm.setLocationRelativeTo(null);
    frm.setVisible(true);
    Point pt = button.getLocationOnScreen();
    Dimension panelSize = hintPanel.getPreferredSize();
    Dimension buttonSize = button.getSize();
    int x = pt.x + buttonSize.width - panelSize.width;
    int y = pt.y - panelSize.height - 10;

    PopupFactory.setSharedInstance(new TranslucentPopupFactory());

    // popup should only be closed when user clicks the "Close" button.
    Popup popup = PopupFactory.getSharedInstance().getPopup(button, hintPanel, x, y);

    popup.show();
    // "link style" button
    closeBtn.addMouseListener(new MouseAdapter() {
      @Override public void mouseEntered(MouseEvent e) {
        Font f = e.getComponent().getFont();
        e.getComponent().setFont(underlineOn(f));
      }

      @Override public void mouseExited(MouseEvent e) {
        e.getComponent().setFont(UIManager.getFont("Label.font"));
      }

      @Override public void mousePressed(MouseEvent e) {
        popup.hide();
      }
    });
  }

  public static Font underlineOn(Font aBaseFont) {
    return aBaseFont.deriveFont(Collections.singletonMap(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON));
  }

  static class TextBubbleBorder extends AbstractBorder {
    private Color color;
    private int thickness = 4;
    private int radii = 8;
    private int pointerSize = 7;
    private Insets insets = null;
    private BasicStroke stroke = null;
    private int strokePad;
    private int pointerPad = 4;
    private boolean left = true;
    RenderingHints hints;

    TextBubbleBorder(Color color) {
      this(color, 4, 8, 7);
    }

    TextBubbleBorder(Color color, int thickness, int radii, int pointerSize) {
      this.thickness = thickness;
      this.radii = radii;
      this.pointerSize = pointerSize;
      this.color = color;

      stroke = new BasicStroke(thickness);
      strokePad = thickness / 2;

      hints = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

      int pad = radii + strokePad;
      int bottomPad = pad + pointerSize + strokePad;
      insets = new Insets(pad, pad, bottomPad, pad);
    }

    TextBubbleBorder(Color color, int thickness, int radii, int pointerSize, boolean left) {
      this(color, thickness, radii, pointerSize);
      this.left = left;
    }

    @Override public Insets getBorderInsets(Component c) {
      return insets;
    }

    @Override public Insets getBorderInsets(Component c, Insets insets) {
      return getBorderInsets(c);
    }

    @Override public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
      Graphics2D g2 = (Graphics2D) g;
      int bottomLineY = height - thickness - pointerSize;
      RoundRectangle2D.Double bubble =
        new RoundRectangle2D.Double(0 + strokePad, 0 + strokePad, width - thickness, bottomLineY, radii, radii);

      Polygon pointer = new Polygon();

      if (left) {
        pointer.addPoint(strokePad + radii + pointerPad, bottomLineY);
        pointer.addPoint(strokePad + radii + pointerPad + pointerSize, bottomLineY);
        pointer.addPoint(strokePad + radii + pointerPad + (pointerSize / 2), height - strokePad);
      } else {
        pointer.addPoint(width - (strokePad + radii + pointerPad), bottomLineY);
        pointer.addPoint(width - (strokePad + radii + pointerPad + pointerSize), bottomLineY);
        pointer.addPoint(width - (strokePad + radii + pointerPad + (pointerSize / 2)), height - strokePad);
      }

      Area area = new Area(bubble);
      area.add(new Area(pointer));

      g2.setRenderingHints(hints);

      // Paint the BG color of the parent, everywhere outside the clip
      // of the text bubble.
      Component parent = c.getParent();
      if (parent != null) {
        Color bg = parent.getBackground();
        // Rectangle rect = new Rectangle(0, 0, width, height);
        // Area borderRegion = new Area(rect);
        // borderRegion.subtract(area);
        // g2.setClip(borderRegion);
        // g2.setColor(bg);
        // g2.fillRect(0, 0, width, height);
        // g2.setClip(null);
        g2.setPaint(bg);
        g2.fill(area);
      }
      g2.setColor(color);
      g2.setStroke(stroke);
      g2.draw(area);
    }
  }
}

/*
@see http://today.java.net/pub/a/today/2008/03/18/translucent-and-shaped-swing-windows.html
https://web.archive.org/web/20150515015137/http://today.java.net/pub/a/today/2008/03/18/translucent-and-shaped-swing-windows.html
Translucent and Shaped Swing Windows | Java.net
*/
class TranslucentPopupFactory extends PopupFactory {
  @Override public Popup getPopup(Component owner, Component contents, int x, int y) {
    return new TranslucentPopup(owner, contents, x, y);
  }
}

class TranslucentPopup extends Popup {
  private final JWindow popupWindow;

  protected TranslucentPopup(Component owner, Component contents, int ownerX, int ownerY) {
    super(owner, contents, ownerX, ownerY);
    // create a new heavyweight window
    this.popupWindow = new JWindow();
    // mark the popup with partial opacity
    // AWTUtilities.setWindowOpacity(popupWindow, (contents instanceof JToolTip) ? .8f : .95f);
    // popupWindow.setOpacity(.5f);
    // AWTUtilities.setWindowOpaque(popupWindow, false); // Java 1.6.0_10
    popupWindow.setBackground(new Color(0x0, true)); // Java 1.7.0
    // determine the popup location
    popupWindow.setLocation(ownerX, ownerY);
    // add the contents to the popup
    popupWindow.getContentPane().add(contents);
    contents.invalidate();
    // JComponent parent = (JComponent) contents.getParent();
    // set the shadow border
    // parent.setBorder(new ShadowPopupBorder());
  }

  @Override public void show() {
    System.out.println("Always Heavy weight!");
    this.popupWindow.setVisible(true);
    this.popupWindow.pack();
    // mark the window as non-opaque, so that the
    // shadow border pixels take on the per-pixel
    // translucency
    // AWTUtilities.setWindowOpaque(this.popupWindow, false);
  }

  @Override public void hide() {
    this.popupWindow.setVisible(false);
    this.popupWindow.removeAll();
    this.popupWindow.dispose();
  }
}