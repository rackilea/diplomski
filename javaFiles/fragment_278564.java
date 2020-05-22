Iterator<Brick> it = brickEnemies.iterator();
while (it.hasNext()) {
  Brick brick = it.next();
  int newPosition_X = brick.getPositionX() - SPEED;
  if (newPosition_X > 0) {
       brick.setPositionX(newPosition_X);
  } else {
       it.remove();
  }
}