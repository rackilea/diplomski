import java.applet.Applet;
     public class OurApplet extends Applet {
             public void init() {
                    Runnable ot = new OurClass();
                    Thread th = new Thread(ot);
                    th.start();
                      }
                 }