public Cell moveMe(Person p){
    Cell northOfHere = null;
    try{
        northOfHere = grid.grid[y-1][x];
        northOfHere.add(p);
    }catch(ArrayIndexOutOfBoundsException ex){
        System.out.println("fell from edge");/*person falls from the edge of the world*/
    }
    System.out.format("Remove from %s person %s%n", this, p);
    System.out.println("removed: " + inhabs.remove(p));
    return northOfHere;
}