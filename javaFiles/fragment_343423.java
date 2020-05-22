int[] grid = new int[64];
long  full = 0L;

// place a piece at a certain grid position
grid[17] = 1;   // pretend 1 is the code for black
full |= 1L << 17;   // set bit 17 in our "full" tracker

// is the grid full?
if (full == -1L)
     // yes it is!
else
     // no it isn't