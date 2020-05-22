public JFrame1 () { // Constructor
    ...
    button.addActionListener(new ActionListener() { //when button is pressed
        public void actionPerformed(ActionEvent e) {
        JFrame3 obj3 = new JFrame3(); // open JFrame3
        JFrame2 obj2 = new JFrame2(obj3); // open JFrame2
        }
    });
}