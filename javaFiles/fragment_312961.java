import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

public class TextFieldLimit
{
    private void createAndDisplayGUI()
    {
        JFrame frame = new JFrame("JTextField Limit");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLocationByPlatform(true);

        JPanel contentPane = new JPanel();

        JTextField tfield = new JTextField(10);
        /*
         * Here we are using Document Filter
         * to specify the size of the content
         * i.e. 8 in your case.
         */
        ((AbstractDocument)tfield.getDocument()).setDocumentFilter(
                                        new DocumentLimitAndInput(8));

        contentPane.add(tfield);

        frame.getContentPane().add(contentPane);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String... args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            public void run()
            {
                new TextFieldLimit().createAndDisplayGUI();
            }
        });
    }
}

class DocumentLimitAndInput extends DocumentFilter
{
    private int maxCharacters;

    public DocumentLimitAndInput(int size)
    {
        maxCharacters = size;
    }

    public void insertString(FilterBypass fb, int offset
                                , String text, AttributeSet aset)
                                        throws BadLocationException
    {
        int size = fb.getDocument().getLength() + text.length();
        /*
         * If the size is less than or equal to the permissible value
         * and the input character is either 0 or 1, only in that
         * case we will allow it to go through, else a BEEP 
         * sound is what a user will hear :-)
         */
        if (size <= maxCharacters && (text.equals("0") || text.equals("1")))
            super.insertString(fb, offset, text, aset);
        else
            Toolkit.getDefaultToolkit().beep();
    }

    public void replace(FilterBypass fb, int offset, int length
                                , String text, AttributeSet aset)
                                        throws BadLocationException
    {
        int size = fb.getDocument().getLength() + text.length();
        /*
         * If the size is less than or equal to the permissible value
         * and the input character is either 0 or 1, only in that
         * case we will allow it to go through, else a BEEP 
         * sound is what a user will hear :-)
         */
        if (size <= maxCharacters && (text.equals("0") || text.equals("1")))
            super.replace(fb, offset, length, text, aset);
        else
            Toolkit.getDefaultToolkit().beep();
    }
}