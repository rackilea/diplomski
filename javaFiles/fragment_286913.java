txtMode.getDocument().addDocumentListener(new DocumentListener() {
    public void insertUpdate(DocumentEvent e) {
        if (!mode.equals(e.getDocument()))

        if (!updateFromModel){
           txtMode.setBackground(Color.red);
        }  
    }

    public void removeUpdate(DocumentEvent e) {
        if (mode.equals(e.getDocument()))

        if (!updateFromModel){
           txtMode.setBackground(Color.white);
        }  
    }

    public void changedUpdate(DocumentEvent e) {
        //To change body of implemented methods
    }
});