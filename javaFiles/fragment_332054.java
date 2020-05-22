import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class ComponentFocus {

    ComponentFocus() {
        final JPanel gui = new JPanel(new GridLayout(0,1,15,15));
        gui.setFocusable(true);
        gui.addMouseListener(new MouseAdapter(){
            @Override 
            public void mouseClicked(MouseEvent me) {
                System.out.println(me);
                gui.requestFocus(true);
            }
        });
        gui.setBackground(Color.RED);
        gui.addFocusListener(new FocusAdapter(){
            @Override
            public void focusGained(FocusEvent fe) {
                gui.setBackground(Color.ORANGE);
            }

            @Override
            public void focusLost(FocusEvent fe) {
                gui.setBackground(Color.RED);
            }
        });

        JButton button1 = new JButton("button1");
        gui.add(button1);
        JButton button2 = new JButton("button2");
        gui.add(button2);

        JOptionPane.showMessageDialog(null, gui);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ComponentFocus();
            }
        });
    }
}