Rectangle r1 = new Rectangle();
Rectangle r2 = new Rectangle();
label1.getBounds(r1);
label2.getBounds(r2);

label1.setBounds(r2);
label2.setBounds(r1);