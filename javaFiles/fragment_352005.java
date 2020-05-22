public void paint (Graphics g) {
        setBackground (Color.red);
        g.setColor(Color.red);
        g.fillRect(0, 0, width, height);
        g.setColor(Color.yellow);
        int a, b;
        a = -50 + (int)(Math.random()*(width+40));
        b = (int)(Math.random()*(height+20));
        g.fillOval(a, b, 130, 110);
    }