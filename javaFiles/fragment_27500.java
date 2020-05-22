Cell[][] cells = new Cell[10][];
cells[0] = new Cell[1];
cells[1] = new Cell[1000];
...

cells[1][5] = 1;  // allowed, since cells[1] is a Cell[] of size 1000
cells[0][5] = 1;  // throws ArrayIndexOutOfBoundsException, since cells[0] has size 1