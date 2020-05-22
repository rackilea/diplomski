class Panel extends JPanel {

    private javax.swing.JButton btn = new javax.swing.JButton("Subir archivo");

    public Panel() {
        add(btn);
    }

    public void addBtnListener(ActionListener l) {
        btn.addActionListener(l);  // !!
    }

}