JScrollPane myScrollPane = new JScrollPane(radioPanel){
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(600, 600);
    }
};
JOptionPane.showConfirmDialog(null, myScrollPane);