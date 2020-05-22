_result.getDocument().addDocumentListener(new DocumentListener() {
        private void atEnd() { 
            _result.setCaretPosition(_result.getText().length()); 
        }
        public void insertUpdate(DocumentEvent evt) { atEnd(); }
        public void removeUpdate(DocumentEvent evt) { atEnd(); }
        public void changedUpdate(DocumentEvent evt) { atEnd(); }
    });