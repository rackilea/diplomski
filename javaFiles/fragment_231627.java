import java.awt.*;
import java.awt.event.*;

public class Gui extends Frame {

    public Gui() {
        setSize(400, 200);
        setLocationByPlatform(true);
        setLayout(new GridBagLayout());

        Canvas cd=new Canvas();
        // TODO: Override rather than set & make it preferred rather than actual
        cd.setSize(300, 100); 
        cd.setBackground(Color.BLUE);
        add(cd);

        addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent arg0) {
                System.exit(0);
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        //paintComponents(g); // wrong method!
        super.paint(g); // right method, but does nothing different to original!
    }

    public static void main(String[] args) {
        // TODO: AWT/Swing based GUIs should be started on the EDT
        Gui g=new Gui();
        g.setVisible(true);
    }
}