JFrame jf = new JFrame("asd");
jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
jf.setSize(200,320);
jf.setLayout(new FlowLayout(FlowLayout.CENTER));
ch1 = new JCheckBox();
ch2 = new JCheckBox();
ch3 = new JCheckBox();
String [] x= {"1","2","3"};
cb = new JComboBox(x);
cb.addItem("Asdd");
cb.addActionListener(e ->{

});
bg = new ButtonGroup();
bg.add(ch1);
bg.add(ch2);
bg.add(ch3);

jf.add(ch1);
jf.add(ch2);
jf.add(ch3);
jf.add(cb);
jf.setVisible(true); //This is where you want to set your JFrame to visible