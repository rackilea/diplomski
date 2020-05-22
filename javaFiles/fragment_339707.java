JFrame frame3=new JFrame();
frame3.setSize(640,480);
JPanel pn=new JPanel();
// Pointless, as the JFrame is using a `BorderLayout`
// so the component will be the available size of it's parent
// container...
//pn.setSize(640,480);
frame3.add(pn);
frame3.setResizable(false);

JTextField tf=new JTextField();
// Pointless, as pn is using a `FlowLayout` so the
// text field will be laid out using it's preferred size
//tf.setSize(300,500);
// Provide a sizing hint, in combination with the fields
// font...
tf.setColumns(25);
Component add = pn.add(tf);

//frame3.pack();
frame3.setVisible(true);