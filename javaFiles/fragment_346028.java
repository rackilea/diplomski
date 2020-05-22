cmdSearch = new AbstractAction("Search", null) {
    public void actionPerformed(ActionEvent evt) {
        final JFileChooser fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        txtSearch.setText( (fc.showOpenDialog(YOURCLASSNAME.this) == JFileChooser.APPROVE_OPTION) ? fc.getSelectedFile().toString() : txtSearch.getText() );                                    
    }
};