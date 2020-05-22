final JLabel last = new JLabel("I'm the last");

int maxRow = 20;
int maxColumn = 10;

JComponent content = new JPanel(new GridLayout(maxRow, maxColumn));
for (int row = 0; row < maxRow; row++) {
    for (int column = 0; column < maxColumn; column++) {
        JComponent parent = new JPanel();
        JLabel label = new JLabel("i'm in " + row + "/" + column);
        if (row == (maxRow - 1) && column == (maxColumn - 1)) {
            label = last;
            last.setBorder(BorderFactory.createLineBorder(Color.RED));
        }
        parent.add(label);
        content.add(parent);
    }
}
JXFrame frame = wrapWithScrollingInFrame(content, "scroll");
Action action = new AbstractAction("scrollLastVisible") {

    @Override
    public void actionPerformed(ActionEvent e) {
        last.scrollRectToVisible(last.getBounds());
    }
};
addAction(frame, action);
show(frame, frame.getPreferredSize().width / 2, frame.getPreferredSize().height / 2);