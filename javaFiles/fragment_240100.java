protected long invadersLastMovedMillis;

protected void moveInvaders() {
  long currentTime = System.currentTimeMillis();
  if ((invadersLastMovedMillis != 0)
      && ((currentTime - invadersLastMovedMillis) < 1000L)) {
    return; // No need to move them yet.
  }
  // March on, space invaders!
  invadersLastMovedMillis = currentTime;
}