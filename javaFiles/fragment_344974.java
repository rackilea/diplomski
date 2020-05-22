Split column1 = new Split();
column1.setRowLayout(false);

Split row = new Split();

Split column2 = new Split();
column2.setRowLayout(false);

column2.setChildren(new Leaf("middle.top"), new Divider(), new Leaf(
    "middle"), new Divider(), new Leaf("middle.bottom"));

row.setChildren(new Leaf("left"), new Divider(), column2,
    new Divider(), new Leaf("right"));

column1.setChildren(row, new Divider(), new Leaf("bottom"));

// Once the layout is done, the code is easy
JXMultiSplitPane msp = new JXMultiSplitPane();
MultiSplitLayout layout = new MultiSplitLayout(column1);
msp.setLayout(layout);
msp.add(new JButton("bottom"), "bottom");
msp.add(new JButton("left"), "left");
msp.add(new JButton("right"), "right");
msp.add(new JButton("middle.bottom"), "middle.bottom");
msp.add(new JButton("middle"), "middle");
msp.add(new JButton("middle.top"), "middle.top");