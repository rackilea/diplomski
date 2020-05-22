import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;

public class MirrorTextSelection {

    public static void main(String[] args) {
        new MirrorTextSelection();
    }

    public MirrorTextSelection() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        private JTextArea left;
        private JTextArea right;

        private DefaultHighlighter.DefaultHighlightPainter highlightPainter;

        public TestPane() {

            highlightPainter = new DefaultHighlighter.DefaultHighlightPainter(UIManager.getColor("TextArea.selectionBackground"));

            left = new JTextArea(20, 20);
            left.setWrapStyleWord(true);
            left.setLineWrap(true);
            right = new JTextArea(20, 20);
            right.setWrapStyleWord(true);
            right.setLineWrap(true);

            left.setText("I am trying to do a small app that compares two similar texts contained in 2 JTextarea. I am wondering if it's possible to select text from the first JTextarea and automatically select the text on the second JTeaxtarea (lets consider that it's guarantee that the 2 JTextarea will have the same text for now) ? Should I share events or listeners ? Thank you");
            right.setText("I am trying to do a small app that compares two similar texts contained in 2 JTextarea. I am wondering if it's possible to select text from the first JTextarea and automatically select the text on the second JTeaxtarea (lets consider that it's guarantee that the 2 JTextarea will have the same text for now) ? Should I share events or listeners ? Thank you");

            setLayout(new GridLayout(0, 2));

            add(new JScrollPane(left));
            add(new JScrollPane(right));

            left.getCaret().addChangeListener(new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent e) {
                    int dot = left.getCaret().getDot();
                    int mark = left.getCaret().getMark();

                    right.setCaretPosition(mark);
                    right.moveCaretPosition(dot);
                }
            });
        }
    }
}