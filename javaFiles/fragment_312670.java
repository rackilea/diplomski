class MyActionListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        lblNylabel.setText("New label text");
    }
}

class YourClass {

    public void yourMethod() {
        ...
        btnNewButton.addActionListener(new MyActionListener());
    }
}