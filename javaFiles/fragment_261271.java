final JTextArea textArea = new JTextArea();
    textArea.addCaretListener(new CaretListener() {
        @Override
        public void caretUpdate(CaretEvent e) {
            String selectedText = textArea.getSelectedText();
            // do something with it...
        }
    });