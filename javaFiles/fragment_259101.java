JPanel sscp= new JPanel();
sscp.setLayout(new FlowLayout(FlowLayout.LEFT));
JLabel sscper= new JLabel("Ssc Percentage",JLabel.LEFT);
JTextField sscperinput=new JTextField(3);
sscp.add(sscper);
sscp.add(sscperinput);

JPanel buttonPanel= new JPanel();
JButton save= new JButton("Save");
JButton cancel= new JButton("Cancel");
buttonPanel.add(save);
buttonPanel.add(cancel);
//change here
sscp.add(buttonPanel);
jf.add(sscp);