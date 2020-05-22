public LifeModel(int rows, int cols)
{
    this.numRows=rows;
    this.numCols=cols;
    world = new boolean[rows][cols];
    initWorld();
    //tempWorld = world;  // You can remove this line.
}