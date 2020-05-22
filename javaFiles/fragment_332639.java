public boolean jump2(Location loc){
    Grid<Actor> gr = getGrid();
    if (gr == null)
        return false;

    Location jump1 = new Location(loc.getRow() + 2, loc.getCol() - 2);
    Location jump2 = new Location(loc.getRow() + 2, loc.getCol() + 2);
    Location adjacent1 = new Location(loc.getRow() + 1, loc.getCol() - 1);
    Location adjacent2 = new Location(loc.getRow() + 1, loc.getCol() + 1);

    // try one column
    if( gr.isValid(jump1))
    {
        if( (gr.get(jump1) == null) && 
            (gr.get(adjacent1) instanceof BlackPieces))
        {
            gr.get(adjacent1).removeSelfFromGrid();
            moveTo(jump1);
            return true;
        }
    }

    // try the other column
    if( gr.isValid(jump2))
    {
        if( (gr.get(jump2) == null) && 
             (gr.get(adjacent2) instanceof BlackPieces))
        {
            gr.get(adjacent2).removeSelfFromGrid();
            moveTo(jump2);
            return true;
        }
    }

    return false;
}