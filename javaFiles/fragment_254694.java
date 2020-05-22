Path pathX = new Path.Up();
Path pathY = new Path.Down(n);
Path pathZ = new Path.Fixed(3);

for (int i = 0; i < n; i++) {
    if(mat[pathX.pos(i)][pathY.pos(i)][pathZ.pos(i)] != specificValue) {
        doStuff();  
    }
}