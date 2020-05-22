String x; //instance variable to be shared
private void initialize() {
    ...
    JButton btn1 = new JButton("Button 1");
    btn1.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            x = "1";
            textField1.setText(x);              
        }
    });

    JButton btn2 = new JButton("Button 2");
    btn2.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            textField2.setText(x);
        }
    });

}