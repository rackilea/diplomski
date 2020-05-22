Document doc = myTextField.getDocument();
doc.addDocumentListener(new DocumentListener() {

        void insertUpdate(DocumentEvent e) {
            // ... code to check document change here
        }

        void removeUpdate(DocumentEvent e){
            // ... code to check document change here
        }

        void changedUpdate(DocumentEvent e){
            // ... code to check document change here
        }

});