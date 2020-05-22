MouseListener ml = new MouseListener() {
    @Override
    public void mouseReleased(MouseEvent e) {//code}

    @Override
    public void mousePressed(MouseEvent e) {//code}

    @Override
    public void mouseExited(MouseEvent e) {//code}

    @Override
    public void mouseEntered(MouseEvent e) {//code}

    @Override
    public void mouseClicked(MouseEvent e) {//code}
};

JLabel j1 = new JLabel("Label1");
j1.addMouseListener(ml);
JLabel j2 = new JLabel("Label2");
j2.addMouseListener(ml);