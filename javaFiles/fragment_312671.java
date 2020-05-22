class YourClass {

    public void yourMethod() {
        ...
        btnNewButton.addActionListener(new MyActionListener());
    }

    // Inner class
    class MyActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            lblNylabel.setText("New label text");
        }
    }
}