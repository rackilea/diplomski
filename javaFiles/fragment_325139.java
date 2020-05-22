timer.scheduleAtFixedRate(new TimerTask() {
    public void run() {
        if (!paintQueue.isEmpty()) {
            Nodes node= paintQueue.poll();
            node.setColor(Color.cyan);
        }     
    }
}, initialDelay, 1000);