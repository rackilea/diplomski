import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;

public class Test5
{
    public static void createAndShowGUI()
    {
        String text = "one\ntwo\nthree\nfour\nfive";
        JFrame frame = new JFrame("title");
        JTextArea textArea = new JTextArea(text, 1, 30); // shows only one line
        JScrollPane scrollPane = new JScrollPane( textArea );
        frame.add(scrollPane);
        frame.pack();
        frame.setVisible(true);

        final JViewport viewport = scrollPane.getViewport();

        textArea.addCaretListener( new CaretListener()
        {
            public void caretUpdate(CaretEvent e)
            {
                SwingUtilities.invokeLater(new Runnable()
                {
                    public void run()
                    {
                        System.out.println("First : " + viewport.getViewPosition() );

                        SwingUtilities.invokeLater(new Runnable()
                        {
                            public void run()
                            {
                                System.out.println("Second: " + viewport.getViewPosition() );
                            }
                        });
                    }
                });
            }
        });

        textArea.setCaretPosition(text.length());
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}