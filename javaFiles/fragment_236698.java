@Override
public void replace(FilterBypass fb, int offs, int length, String str, AttributeSet a) throws BadLocationException {
    if (str == null || str.equals("")) {
        super.replace(fb, offs, length, str, a);
    } else {
        // check if 'str' contains 8 digits
        if (str.matches("^\\d{8}$")) {
            // add the dashes
            super.replace(fb, offs, length, str.replaceAll("(\\d{4})(\\d{2})(\\d{2})", "$1-$2-$3"), a);
        } else {
            StringBuffer buffer = new StringBuffer(str);
            for (int i = buffer.length() - 1; i >= 0; i--) {
                char ch = buffer.charAt(i);
                if (!Character.isDigit(ch)) {
                    buffer.deleteCharAt(i);
                }
            }

            str = buffer.toString();
            // sign and sign2 is char number were separator(sep) is written
            if (fb.getDocument().getLength() + str.length() == sign) {
                str = str + sep;
            }
            if (fb.getDocument().getLength() + str.length() == sign2) {
                str = str + sep;
            }

            if ((fb.getDocument().getLength() + str.length() - length) <= maxCharacters)
                super.replace(fb, offs, length, str, a);
            else
                Toolkit.getDefaultToolkit().beep();
        }
    }
}