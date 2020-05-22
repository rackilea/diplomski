JMenuItem item = new JMenuItem("Edit                       ");
item.setLayout( new FlowLayout(FlowLayout.RIGHT, 5, 0) );
JButton copy = new JButton("Copy");
copy.setMargin(new Insets(0, 2, 0, 2) );
item.add( copy );
menu.add( item );