public void paintComponent(Graphics g)
{
    super.paintComponent(g);
    int panelWidth = this.getWidth();
    int panelHeight = this.getHeight();
    g.drawRoundRect(0, 0, panelWidth - 1, panelHeight - 1, 10, 10);
    card = playingdeck.drawTopCard();
    g.drawString(card.toString(), 75, 75);  // you're calling toString() here...
}