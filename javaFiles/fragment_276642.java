private void renderGame(Graphics2D g) {
    g.rotate(Math.toRadians(player.rot), player.getX()+64, player.getY()+64);
    g.drawImage(player.getCurrentFrame(), (int)player.getX(), (int)player.getY(), player.getWidth(), player.getHeight(), null);
    g.setColor(Color.RED);
    g.drawRect((int)player.getX() -5, (int)player.getY() -5, 10, 10);
    g.rotate(-Math.toRadians(player.rot), player.getX()+64, player.getY()+64);
    //...