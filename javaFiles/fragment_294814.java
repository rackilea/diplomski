JFrame myFrame = new JFrame("SingSong");
myFrame.setLocation(100, 100);
myFrame.setSize(new Dimension(1024, 800));

GridLayout layout = new GridLayout(2, 1);
myFrame.setLayout(layout);

JPanel jp = new JPanel();
jp.setBackground(new Color(0x00FF00FF));

JPanel jp2 = new JPanel(new BorderLayout());
jp2.setBackground(new Color(0x00000000));

myFrame.add(jp);
myFrame.add(jp2);

myFrame.setVisible(true);