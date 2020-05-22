this.setLayout(new GridLayout(2,1));

JButton button = new JButton("Click Me!");
JPanel bottomPanel = new JPanel(new GridLayout(1,2));

JLabel label = new JLabel("Enter:");
JTextField textField = new JTextField();

bottomPanel.add(label);
bottomPanel.add(textField);

add(button);
add(bottomPanel);