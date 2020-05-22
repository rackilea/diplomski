void addCells(Point current) {
   // Left
   if (emptyAndNotChecked(current.x-1,current.y)) // Checking for walls here
      cellsToCheck.add(new Point(x-1,y)) // Adding this cell to the list
   // Right
   if (emptyAndNotChecked(current.x+1,current.y))
      cellsToCheck.add(new Point(x+1,y))
   // Top
   if (emptyAndNotChecked(current.x,current.y+1))
      cellsToCheck.add(new Point(x,y+1))
   // Bottom
   if (emptyAndNotChecked(current.x,current.y-1))
      cellsToCheck.add(new Point(x,y-1))
}