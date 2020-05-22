if (cell.hasRightWall()) {
  int fromX = j * CELL_DIM + CELL_DIM;
  int fromY = i * CELL_DIM;

  if (fromX >= image.getWidth()) {
    fromX = image.getWidth() - 1;
  }

  g2.drawLine(fromX, fromY, fromX, fromY + CELL_DIM);
}