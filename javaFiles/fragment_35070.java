import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;

public class Test
{
    public static void main(String args[]) throws Exception
    {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JTextArea textArea = new JTextArea(4, 20);
                JScrollPane scrollPane = new JScrollPane( textArea );
                JPanel panel = new JPanel();
                panel.add( scrollPane );

                scrollPane.addAncestorListener( new AncestorListener()
                {
                    public void ancestorAdded(AncestorEvent e)
                    {
                        JScrollPane scrollPane = (JScrollPane)e.getComponent();
                        scrollPane.applyComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
                    }

                    public void ancestorMoved(AncestorEvent e) {}
                    public void ancestorRemoved(AncestorEvent e) {}
                });

                JOptionPane.showMessageDialog(null, panel);
            }
        });
    }
}