lp = new LimitPanel(st, 6);
// You can check this by using the hashCode of the object...
System.out.println(lp.hashCode());
pn.add(lp);

JButton sabt = new JButton("  ثبت  ");
sabt.addActionListener(new LimitActionHandler(lp));