public Survival() {
        setTitle("Survival");
        setResizable(false);
        setSize(applicationWidth, applicationHeight);
        setVisible(true);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        repaint();
    }

    public void paint(Graphics g) {
        super.paint(g);    
        g.drawString("Test", 120, 120); //change the co-odrinates
    }