public void highLight(JTextComponent component, String patteren) {
    try {
        Document doc = component.getDocument();
        String text = component.getText(0, doc.getLength());
        int pos = component.getCaretPosition();
        boolean found = false;
        int findLength = patteren.length();
        // Rest the search position if we're at the end of the document
        if (pos + findLength > doc.getLength()) {
            pos = 0;
        }
        while (pos + findLength <= doc.getLength()) {
            // Extract the text from teh docuemnt
            String match = doc.getText(pos, findLength).toLowerCase();
            // Check to see if it matches or request
            if (match.equals(patteren)) {
                found = true;
                break;
            }
            pos++;
        }

        if (found) {
            component.setSelectionStart(pos);
            component.setSelectionEnd(pos + patteren.length());
            component.getCaret().setSelectionVisible(true);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}