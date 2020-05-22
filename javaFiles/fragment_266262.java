Timer timer = new Timer (40, new ActionListener(){
    public void actionPerformed(ActionEvent e) {
        for (Ball ball: balls) {
            ball.move();
            repaint();
        }
    }
});