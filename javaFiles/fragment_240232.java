JPanel panel1 = new JPanel();
JButton btn = new JButton("Top Button"); // Button is a Component
btn.addActionListener(this);
panel1.add(btn);

JPanel panel2 = new JPanel();
JButton btn2 = new JButton("Buttom Button"); // Button is a Component
panel2.add(btn2);

// A JPanel to hold both panel1 and panel2
JPanel containerPanel = new JPanel(new GridLayout(2, 1));
containerPanel.add(panel1);
containerPanel.add(panel2);

// add only one component to the BorderLayout.NORTH position of the JFrame
add(containerPanel, BorderLayout.NORTH);