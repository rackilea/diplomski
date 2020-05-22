public class WordCounterDocumentFilter extends DocumentFilter {

    @Override
    public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
        int letterCount = text.length();
        int wordCount = text.split("\\s").length;
        String result = "[insert file name here] has " + letterCount + " characters and " + wordCount + " words";
        super.replace(fb, 0, fb.getDocument().getLength(), result, attrs);
    }

}