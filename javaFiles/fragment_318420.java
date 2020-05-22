//move the random and random1 inside for loop for random cell positions
for (int i = 1; i < steps; i++) {
    int random = (int) (Math.random() * 49 + 1);
    int random2 = (int) (Math.random() * 49 + 1);

    Cell cell = new Cell(random, random2, 'N');
    cell.addCellToGrid(grid, random, random2, cell.type);
}