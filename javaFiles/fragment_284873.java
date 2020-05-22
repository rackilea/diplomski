public class ShortFilter extends DocumentFilter {

    protected boolean valid(String text) {


        boolean valid = true;
        for (char check : text.toCharArray()) {

            if (!Character.isDigit(check)) {

                valid = false;
                break;

            }

        }

        if (valid) {

            int iValue = Integer.parseInt(text);

            valid = iValue <= (Short.MAX_VALUE * 2);

        }

        return valid;

    }

    @Override
    public void insertString(FilterBypass fb, int offset, String text, AttributeSet attr) throws BadLocationException {

        StringBuilder sb = new StringBuilder(fb.getDocument().getText(0, fb.getDocument().getLength()));
        sb.insert(offset, text);

        if (valid(sb.toString())) {

            super.insertString(fb, offset, text, attr);

        }

    }

    @Override
    public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {

        if (length > 0) {

            StringBuilder sb = new StringBuilder(fb.getDocument().getText(0, fb.getDocument().getLength()));

            sb.delete(offset, length);
            sb.insert(offset, text);

            if (valid(sb.toString())) {

                super.replace(fb, offset, length, text, attrs);

            }

        } else {

            insertString(fb, offset, text, attrs);

        }

    }
}