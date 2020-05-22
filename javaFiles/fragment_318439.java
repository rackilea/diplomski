if (cell.asksAccess(xi, yi, xf, yf)) {
    cell.releaseCell(xi, yi); //release the previous cell
    move(); // move the object
    cell.blockCell(xi, yi); // blocks the cell where the object is now staying.
    setChanged();
    notifyObservers();
}