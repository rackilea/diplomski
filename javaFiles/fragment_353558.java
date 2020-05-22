Timer timer = new Timer(100, new ActionListener(){
    @Override
    public void actionPerformed(ActionEvent e) {
        if (bresenham.isEmpty()) {
            ((Timer)e.getSource()).stop();
        } else {
            paintList.add(bresemham.get(0));
            bresenham.remove(0);
        }
        repaint();  
    }
});
timer.start();