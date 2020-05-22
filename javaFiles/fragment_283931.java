int count = 0;
p = new Point(p.x-1, p.y-1); // new point here
if (data.contains(p)) {
     count++;
} else if (addingDeadCells) {
    deadCellsToCheck.add(p);
    for (Point z : deadCellsToCheck)  {
        System.out.println(z.toString() + " " + z.hashCode());
    }
    System.out.println();
}