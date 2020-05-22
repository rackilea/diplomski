import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Example extends JFrame{

    private JPanel pane;

    public Example(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addMouseListener(getListener());
        setSize(200,200);
        pane = (JPanel) getContentPane();
        setVisible(true);
    }

    private MouseListener getListener() {
        return new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                pane.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                pane.setCursor(Cursor.getDefaultCursor());
            }
        };
    }

    public static void main(String... s){
        new Example();
    }

}