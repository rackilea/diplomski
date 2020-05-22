private static void update(List<? extends GameSprite> sprites) {

    Iterator<? extends GameSprite> it = sprites.iterator();
    while (it.hasNext()) {
      GameSprite s = it.next();
      s.update();
      if (!s.isActive())
         it.remove();
    }
}