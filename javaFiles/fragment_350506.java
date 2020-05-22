userName.getDocument().addDocumentListener(new DocumentListener() {
    @Override
    public void insertUpdate(DocumentEvent de){
       event(de);
    }

    @Override
    public void removeUpdate(DocumentEvent de) {
        event(de);
    }

    @Override
    public void changedUpdate(DocumentEvent de){
        event(de);
    }

    private void event(DocumentEvent de){
        error.setVisible(de.getDocument().getLength() == 0);
        // as mentioned by nIcE cOw better to use Document from parameter
        frame.revalidate();
        frame.repaint();
    }
});