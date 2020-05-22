// ..
JTextField title = new JTextField(20);  // suggest a size in columns!
//title.setMinimumSize(new Dimension(300,25)); // don't call these methods! (1)
this.add(title,c);

c.gridy=1;
c.gridheight=2;
c.weighty=200;
JTextArea description = new JTextArea(3, 15); // suggest a size in rows/cols!
// ..