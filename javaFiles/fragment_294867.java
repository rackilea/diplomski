public void paintComponent(Graphics g)
{
    text = new JTextField("Enter Name here");
    text.setSize(100,25);
    submitButton = new JButton("Submit");
    submitButton.setSize(50,90);
    submitButton.setBounds(200, 0, 80, 80);
    submitButton.addActionListener(this);
    this.add(text);
    this.add(submitButton);
}