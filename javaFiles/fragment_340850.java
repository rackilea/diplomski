import java.applet.Applet;

import java.awt.Color;
import java.awt.Graphics;

public final class TestingApplet extends Applet {

  public void paint(final Graphics g){
    g.drawOval(0, 0, 250, 100);
    g.setColor(Color.RED);
    g.drawString("My Applet", 10, 50);
  }
}