RelativeLayout rl = new RelativeLayout(RelativeLayout.Y_AXIS);
rl.setFill(true);
setLayout( rl );

JPanel left = new JPanel(new FlowLayout(FlowLayout.LEFT) );
left.add(new JLabel("left"));
add(left);

JPanel right = new JPanel(new FlowLayout(FlowLayout.RIGHT));
right.add(new JLabel("right"));
add(right);