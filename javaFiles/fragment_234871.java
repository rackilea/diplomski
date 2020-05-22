import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PopupMenu extends Box{

    Dimension preferredSize = new Dimension(400,30);

    public PopupMenu(){
        super(BoxLayout.Y_AXIS);

        final JPopupMenu menu = new JPopupMenu("Options");
        for(int i = 1; i < 20; i++)
            menu.add(new JMenuItem("Option" + i));

        JLabel clickMe = new JLabel("ClickMe");
    clickMe.setAlignmentX(RIGHT_ALIGNMENT);
        clickMe.addMouseListener(new MouseAdapter(){

            @Override
            public void mouseClicked(MouseEvent e) {
                menu.show(e.getComponent(), e.getX(), e.getY());
            }});

        add(clickMe);       
    }

    public Dimension getPreferredSize(){
        return preferredSize;
    }

    public static void main(String[] args) {

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new PopupMenu());
        frame.validate();
        frame.pack();
        frame.setVisible(true);
    }
}