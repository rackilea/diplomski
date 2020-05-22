MyPanel(Player[] players) {
        this.players = players;
        setBackground(Color.BLACK);

        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                repaint();
                players[0].moveDown;
            }
        }, 300, 1000 / 60);
    }

 @Override
    public void paint(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.WHITE);

        for(Player p : players){
            p.drawPlayer((Graphics2D) g);
        }
    }