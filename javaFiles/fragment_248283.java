public void paintComponent(java.awt.Graphics g){
    setBackground(Color.GREEN); // !!!!
    Graphics2D gr=(Graphics2D) g;
    for(int x=0;x<Player.hand.size();x++){

        // .... etc ....

        JButton button = new JButton(c.name);  // !!!! yikes !!!!
        button.setSize(c.cardWidth, c.cardHeight);
        //button.setLocation(c.XCord, c.YCord);
        this.add(button);  // !!!! yikes !!!!
        repaint();  // !!!!
    }
}