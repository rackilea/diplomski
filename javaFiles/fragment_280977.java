table.addMouseListener(new MouseAdapater() {

    @Override // never forget this guy
    public void mousePressed(MouseEvent e) {

        // you've got your JTable reference right here!
        JTable selectedTable = (JTable) e.getSource();

        // now what you do with it will depend on your needs and your code
    }
});