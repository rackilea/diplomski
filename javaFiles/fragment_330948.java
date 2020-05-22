jTextPanel.getDocument().addDocumentListener(new DocumentListener(){
        @Override
        public void changedUpdate(DocumentEvent e) {
            isModified=true;                
        }

        @Override
        public void insertUpdate(DocumentEvent e) {
            isModified=true;                
        }
        @Override
        public void removeUpdate(DocumentEvent e) {
            isModified=true;                
        }            
    });