JButton myButton = new JButton("Yellow");
myButton.setBackground(Color.YELLOW);
frame.add(myButton);
myButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(myButton)) {
            if (myButton.getText().equals("Yellow")) {
                myButton.setText("Blue");
                myButton.setBackground(Color.BLUE);
            } else {
                // (MyButton.getText().equals("Blue"))
                myButton.setText("Yellow");
                myButton.setBackground(Color.YELLOW);
            }
        }
    }
});