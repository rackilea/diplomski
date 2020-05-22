JLabel l1 = new JLabel("\uf0c0");
JLabel l2 = new JLabel("This is ascii text");
l1.setFont(fontAwesome);
Box mix = Box.createHorizontalBox();
mix.add(l1); mix.add(l2);
myContainer.add(mix);