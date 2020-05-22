setLayout(new GridBagLayout());

JLabel label1 = new JLabel("FROM  :");
label1.setFont(new Font("Serif", Font.BOLD, 15));

JComboBox cb = new JComboBox();

GridBagConstraints gbc = new GridBagConstraints();
gbc.gridx = 0;
gbc.gridy = 0;
add(label1, gbc);
gbc.fill = GridBagConstraints.HORIZONTAL;
gbc.gridx++;
add(cb, gbc);

JLabel label2 = new JLabel("TO :");
label2.setFont(new Font("Serif", Font.BOLD, 15));
JComboBox cb1 = new JComboBox();

gbc.gridx = 0;
gbc.gridy++;
gbc.fill = GridBagConstraints.NONE;
add(label2, gbc);
gbc.fill = GridBagConstraints.HORIZONTAL;
gbc.gridx++;
add(cb1, gbc);

JLabel label3 = new JLabel("\n\nENTER THE AMOUNT  :");
label3.setFont(new Font("Serif", Font.BOLD, 15));
label3.setHorizontalAlignment(SwingConstants.CENTER);
label3.setVerticalAlignment(SwingConstants.CENTER);

gbc.gridx = 0;
gbc.gridy++;
add(label3, gbc);
JTextField tf1 = new JTextField(15);
gbc.gridx++;
add(tf1, gbc);

JLabel label4 = new JLabel("CONVERTED AMOUNT :");
label4.setFont(new Font("Serif", Font.BOLD, 15));
label4.setDisplayedMnemonic(KeyEvent.VK_O);

gbc.gridx = 0;
gbc.gridy++;
add(label4, gbc);
JTextField tf2 = new JTextField(15);
gbc.gridx++;
add(tf2, gbc);

JPanel buttons = new JPanel();

JButton button1 = new JButton("CONVERT");
button1.setFont(new Font("Serif", Font.BOLD, 15));
button1.setMnemonic(KeyEvent.VK_K);
buttons.add(button1);

JButton button2 = new JButton("CLEAR ");
button2.setFont(new Font("Serif", Font.BOLD, 15));
button2.setMnemonic(KeyEvent.VK_C);
buttons.add(button2);

gbc.gridx = 0;
gbc.gridy++;
gbc.gridwidth = GridBagConstraints.REMAINDER;
add(buttons, gbc);