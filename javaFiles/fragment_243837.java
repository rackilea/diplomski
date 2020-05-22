public void paintComponent(Graphics g) {
    List<GameObject> list = ... // however you obtain it in your game
    for (GameObject gobject : list) {
        g.drawImage(gobject.image, gobject.x, gobject.y, (ImageObserver) null);
    }
}