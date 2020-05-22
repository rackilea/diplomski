private static void end(Graphics g) {
    g.setColor(BG);
    g.fillRect(0, 0, 900, 900);
    g.setFont(new Font("TimesRoman", Font.PLAIN, 40)); 
    g.setColor(FG)  // Here
    g.drawString("GAME OVER!!", 10, 30);
}