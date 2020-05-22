private int steps=0;
private LinkedList<MazeCell> breadCrumbs = new LinkedList<MazeCell>();
private Set<MazeCell> visitedCells = new HashSet<MazeCell>();
public int stepsToSolveMaze(MazeCell cell)
{       
    if (!visitedCells.contains(cell))
    {
        visitedCells.add(cell);
        breadCrumbs.push(cell);
    }   
}