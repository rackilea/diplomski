JFrame frame = new JFrame("Test");
frame.setSize(300, 300);
JLabel label = new JLabel("This is text!!!");
frame.add(label);
frame.setVisible(true);

final int labelWidth = 300;
final AtomicInteger labelPadding = new AtomicInteger();
Timer timer = new Timer(20, new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        label.setBorder(new EmptyBorder(0, labelPadding.getAndIncrement() % labelWidth, 0, 0));
    }
});
timer.start();