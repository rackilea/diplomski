JPanel panel = new JPanel();
panel.setBackground(new Color(0));
panel.setToolTipText("Drag to move frame");

panel.addMouseMotionListener(new MouseMotionAdapter() {
    public void mouseDragged(MouseEvent e) {
       super.mouseDragged(e);
       Test.this.setLocation(e.getXOnScreen(), e.getYOnScreen());
       System.out.println(e);
    }
});

this.setContentPane(panel);