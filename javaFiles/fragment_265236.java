switch (snakeAI.getDirection()) {
  case Snake.DIR_LEFT:
    if (s.x >= px) { // don't go left anymore
      if (s.y > py) {
        snakeAI.setDirection(Snake.DIR_UP);
      } else if (s.y < py) {
        snakeAI.setDirection(Snake.DIR_DOWN);
      } else {
        // You should probably change this
        snakeAI.setDircetion(Snake.DIR_DOWN);
      }
    }
    break;
  case Snake.DIR_RIGHT: