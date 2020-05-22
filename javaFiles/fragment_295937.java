JButton cancel = new JButton("AAAA");
JPanel p = new JPanel();
p.setName("Panel p");
p.add(cancel);
JFrame f = new JFrame();
f.add(p);
f.pack();
f.setVisible(true);
System.out.println(cancel.getParent().getName());