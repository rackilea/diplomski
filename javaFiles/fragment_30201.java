// (-1  1) (0  1) (1  1)
// (-1  0) (----) (1  0)
// (-1 -1) (0 -1) (1 -1)
// from (1 0) anti-clockwise:
static int[] xOffset = {1,1,0,-1,-1,-1,0,1};
static int[] yOffset = {0,1,1,1,0,-1,-1,-1};