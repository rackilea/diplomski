frame2 = new JFrame();
frame2.setBounds(100, 100, 543, 432);
frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame2.getContentPane().setLayout(null);

JList list = new JList(names);
list.setVisibleRowCount(10);

JScrollPane scroller = new JScrollPane(list);
scroller.setBounds(36, 11, 161, 345);

frame2.getContentPane().add(scroller);


JList list_1 = new JList(access);

list_1.setVisibleRowCount(10);

scroller = new JScrollPane(list_1);
scroller.setBounds(356, 11, 161, 345);
frame2.getContentPane().add(scroller);

frame2.setVisible(true);