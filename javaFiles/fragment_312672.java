class YourClass implements ActionListener {

    public void yourMethod() {
        ...
        btnNewButton.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        lblNylabel.setText("New label text");
    }
}