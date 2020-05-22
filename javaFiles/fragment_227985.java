public List<Cell> findPath(int xStart, int yStart, int xGoal, int yGoal) {
    LinkedList<Cell> path = new LinkedList(); //use a linked list, since we don't know how many elements it will contain straight away..
    path.add(new Cell(xStart, yStart));
    HashSet<Cell> visited = new HashSet(); //this set will store all visited cells. Make sure to add any cell you looked at. Don't work with cells which you have visited previously, by checking visited.contains(cell).
    visited.add(path.getFirst());
    //use your path finding algorithm here (note that you can use getLast() and getFirst() on your list.
    return path;
}