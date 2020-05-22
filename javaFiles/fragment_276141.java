public class SwingCapture extends JPanel {
private static final long serialVersionUID = -1284686239737730338L;
public static Player player = null;
public static final int WIDTH = 640;
public static final int HEIGHT = 480;
public MediaLocator ml = null;

public SwingCapture() {
    setLayout(null);
    setSize(WIDTH, HEIGHT);
    JLayeredPane jLP = new JLayeredPane(); 
    jLP.setBounds(0,0,800,600);
    ml = new MediaLocator("vfw:Microsoft WDM Image Capture (Win32):0"); 
    try  {
        Manager.setHint(Manager.LIGHTWEIGHT_RENDERER, true);
        player = Manager.createRealizedPlayer(ml);
        player.start();
        jLP.add(Canvas.getInstance());
        Canvas.getInstance().setBounds(0, 0, 200, 200);
        Component comp = null;
        if ((comp = player.getVisualComponent()) != null) {
            jLP.add(comp, -1);   
            comp.setBounds(0, 0, 640, 480);
        }

        add(jLP);
    } catch (Exception e) {
      e.printStackTrace();
    }
}

 public static void playerclose() 
 {
    player.close();
    player.deallocate();
 }
}