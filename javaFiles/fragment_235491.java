DrawPanel.addMouseListener(new MouseAdapter() {
    public void mouseClicked(MouseEvent e) { 
        CarIcon car = new CarIcon(Width, e.getX(), e.getY());
        JLabel lable = new JLabel (car);
        DrawPanel.add(lable);
        DrawPanel.revalidate();
    } 
});