int[][] a;

void draw(){
  for (bx=0; bx<=7; bx++) {
    for (by=0; by<=4; by++) {
        rect(bx*BRICK_WIDTH, by*BRICK_HEIGHT, BRICK_WIDTH, BRICK_HEIGHT); 
        int[][] a = {{bx}, {by}};
    }
    println (a[bx][by]);
  }
}