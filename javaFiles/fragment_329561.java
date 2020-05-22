public void moveTo(Location newLocation)
{
    Location loc = new Location(getGrid().getNumCols(), getGrid().getNumRows());
    moveTo(loc);
    sideLength = 0;
}