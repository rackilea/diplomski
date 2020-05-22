GridBagConstraints c = new GridBagConstraints();
c.fill = GridBagConstraints.HORIZONTAL;
// c.insets=new Insets(5,5,5,5);   // margin outside the panel

JPanel topPanel = new JPanel(new GridBagLayout());

JLabel jlbempty = new JLabel("MacAddress");
c.gridx = 0;
c.gridy = 0;
// c.weightx=0.25;     // width 25% for 1st column
topPanel.add(jlbempty, c);

JTextField field1 = new JTextField();
c.gridx = 1;
c.gridy = 0;
// c.weightx=0.75;     // width 75% for 2nd column
topPanel.add(field1, c);

JButton jb = new JButton("Generation Mac");
c.gridx = 0;
c.gridy = 1;
//c.gridwidth = 2;    //SPAN to 2 columns if needed
// c.weightx=1.0;     // back to width 100%
topPanel.add(jb, c);