p.getFinestra().getContentPane().setLayout(new FlowLayout());
p.getFinestra().getContentPane().add(c);
p.getFinestra().getContentPane().add(c2);

//It is also a good habit to call pack() before setting to visible
p.getFinestra().pack()
p.getFinestra().setVisible(true);