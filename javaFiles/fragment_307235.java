JSplitPane pane = new JSplitPane();
pane.setResizeWeight(1/3f); // right will be twice size of left

JPanel left = new JPanel();
left.setBorder(BorderFactory.createTitledBorder("Left"));
pane.setLeftComponent(left);

JPanel right = new JPanel();
right.setBorder(BorderFactory.createTitledBorder("Right"));
pane.setRightComponent(right);