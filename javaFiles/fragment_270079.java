JTextArea textArea = new JTextArea();

    ((AbstractDocument) textArea.getDocument()).setDocumentFilter(new DocumentFilter() {            
        @Override
        public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs)
                throws BadLocationException {

            if ("a".equals(text)) {
                text = "B";
            }               

            super.replace(fb, offset, length, text, attrs);
        }
    });