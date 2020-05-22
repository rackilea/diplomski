import javax.swing.*;
import javax.swing.text.*;
import java.awt.Toolkit;

public class ConversionFilter extends DocumentFilter
{
    private boolean arabic;
    private JTextField converted;

    public ConversionFilter(boolean arabic, JTextField converted)
    {
        this.arabic = arabic;
        this.converted = converted;
    }

    @Override
    public void insertString(FilterBypass fb, int offs, String str, AttributeSet a)
        throws BadLocationException
    {
        super.insertString(fb, offs, str, a);

        convertInput(fb);
    }

    @Override
    public void replace(final FilterBypass fb, final int offs, final int length, final String str, final AttributeSet a)
        throws BadLocationException
    {
        super.replace(fb, offs, length, str, a);
        convertInput(fb);
    }

    @Override
    public void remove(DocumentFilter.FilterBypass fb, int offset, int length)
        throws BadLocationException
    {
        super.remove(fb, offset, length);
        convertInput(fb);
    }

    private void convertInput(DocumentFilter.FilterBypass fb)
    {
        //  Remove the DocumentFilter from the text field to be converted

        AbstractDocument document = (AbstractDocument)converted.getDocument();
        DocumentFilter df = document.getDocumentFilter();
        document.setDocumentFilter( null );

        //  Do the conversion and update the text field

        String text = fb.getDocument().getText();
        String convertedText = arabic ? convertToRoman(text) : convertToArabic(text);
        converted.setText( convertedText );

        //  Restore the DocumentFilter on the converted text field

        document.setDocumentFilter( df );
    }
}