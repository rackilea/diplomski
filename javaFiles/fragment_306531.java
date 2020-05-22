@Override
public void keyPressed(KeyEvent e) {

    switch (e.getKeyCode()) {
        case KeyEvent.VK_W:
            player.moveUp();
            System.out.println(player.getCenterY());
            break;
        case KeyEvent.VK_S:
            player.moveDown();
            System.out.println(player.getCenterY());
            break;
        case KeyEvent.VK_A:
            player.moveLeft();
            System.out.println(player.getCenterX());
            break;
        case KeyEvent.VK_D:
            player.moveRight();
            System.out.println(player.getCenterX());
            break;
    }

    player.update();
}