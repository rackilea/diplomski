import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

public class GUITest
{
    private JFrame frame;

    public void init()
    {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ((JPanel)frame.getContentPane()).setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        JTextField txt = new JTextField(5);
        ((AbstractDocument) txt.getDocument()).setDocumentFilter(new OneLetterFilter());

        frame.add(txt);
        frame.pack();
    }

    public void showGUI()
    {
        frame.setVisible(true);
    }

    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                GUITest gui = new GUITest();
                gui.init();
                gui.showGUI();
            }
        });
    }

    class OneLetterFilter extends DocumentFilter
    {
        @Override
        public void replace(DocumentFilter.FilterBypass fb, int offset, int length, String text, AttributeSet attr) throws BadLocationException
        {
            String oldText = fb.getDocument().getText(0, fb.getDocument().getLength());
            fb.replace(0, oldText.length(), text.substring(text.length() - 1), attr);
        }
    }
}