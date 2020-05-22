JFrame frame=new JFrame("Box ordering test");
Box box=Box.createVerticalBox();
frame.setContentPane(box);
box.add(new JLabel("One"));
box.add(new JLabel("Two"));
box.add(new JLabel("Three"));
box.add(new JLabel("Four"));
box.add(new JLabel("Five"));
MouseMotionListener l=new MouseMotionAdapter() {
    @Override
    public void mouseDragged(MouseEvent e) {
        Component c=e.getComponent();
        Container p=c.getParent();
        int count = p.getComponentCount();
        int newPos=Math.max(0, Math.min(count,
            (e.getY()+c.getY())*count/p.getHeight()));
        if(newPos!=p.getComponentZOrder(c)) {
            p.setComponentZOrder(c, newPos);
            p.revalidate();
            p.repaint();
        }
    }
};
for(Component c: box.getComponents()) c.addMouseMotionListener(l);
frame.pack();
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setVisible(true);