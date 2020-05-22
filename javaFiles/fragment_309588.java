private Cell bufferCell;

@Override
public boolean onTouchEvent(MotionEvent event)
{
  Cell cell = getCell(event);
  if (cell != null)
  {
    switch (event.getAction())
    {
      case MotionEvent.ACTION_DOWN:
        if (cell != bufferCell)
          bufferCell = cell;

        // DO STUFF HERE.
        // THE PLAYER HAS JUST TOUCHED A CELL.
        // invalidate();
        break;
      case MotionEvent.ACTION_MOVE:
        if (cell != bufferCell)
        {
          bufferCell = cell;
          // Continue Pan
          // DO STUFF HERE
          // THE PLAYER'S FINGER IS ON A DIFFERENT CELL NOW, AND MOVING
          // invalidate();
        }
        break;
      case MotionEvent.ACTION_UP:
        // Commit Pan
        bufferCell = null;
        // DO STUFF HERE
        // THE PLAYER HAS TAKEN HIS FINGER OFF THE VIEW
        // invalidate();
        break;
    }
  }
  return true;
}

private Cell getCell(MotionEvent event)
{
  int motionX = (int) event.getX();
  int motionY = (int) event.getY();
  if (motionX > 0 && motionX < sizeOfGrid && motionY > 0
      && motionY < sizeOfGrid)
  {
    int rowIndex = motionY / currentSizeOfCell % rowCount;
    int columnIndex = motionX / currentSizeOfCell % columnCount;
    return cellArray[rowIndex][columnIndex];
  }
  return null;
}