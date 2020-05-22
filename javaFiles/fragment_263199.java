Timer time = new Timer();
time.schedule(new TimerTask() {
    public void run() {
        String coords = getCoords();
        System.out.println(coords);
        frame.getContentPane().repaint();
    }
}, 0, 250);