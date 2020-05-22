int delay = 100;
JButton speedUp = new JButton("Speed UP");
JButton slowDown = new JButton("Slow Down");
Timer timer = null;
public Pipes() {
    timer = new Timer(delay, new ActionListener(){
        ...
    });
    timer.start();

    speedUp.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e) {
            if (!((delay - 20) < 0)) {
                delay -=20;
                timer.setDelay(delay);
            }
        }
    });
    // do the same for slowDown, but decrease the delay
}