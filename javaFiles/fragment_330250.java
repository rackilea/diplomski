private int fps = 3;
private boolean stop = false;

public void paintComponent(Graphics g){
    super.paintComponent(g);
    long time = 5000;
    animate_with_gfx(g, time, fps, stop);
}

/** Called from constructor..  */
public void init(){
    Timer t = new Timer((int)(1000/fps), new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            if(!stop) {
                repaint();
            } else {
                ((Timer)e.getSource()).stop();
            }
        }
    });
    t.setRepeats(true);
    t.setDelay((int)(1000/fps));
    t.start();
}