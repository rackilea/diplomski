String x = "0";

JButton btn1 = new JButton("Button 1");
btn1.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        String x = "1";
        textField1.setText(x);              
    }
});