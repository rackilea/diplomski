public void paintComponent(Graphics g){
    super.paintComponent(g);
    long time = 5000; int fps = 3;
    boolean stop = false;
    Timer t = new Timer((int)(1000/fps), new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            if(!stop) {
                animate_with_gfx(g, time, fps, stop);
                repaint();
            } else {
                ((Timer)e.getSource()).stop();
            }
        }
    });
    t.setRepeats(true);
    t.setDelay((int)(1000/fps));
    t.start();
    System.exit(0);
}