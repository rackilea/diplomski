jButtonSearch.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e)
    {
        String kw = jTextFieldMC.getText();
        table.setModel(new ProductTableModel(ca.SearchByKeyWord(kw)));
    }
});