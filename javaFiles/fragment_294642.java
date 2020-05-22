int N, M;
int[][] cell;
public Maze(int N, int M) {
    this.N = N;
    this.M = M;
    this.cell = new int[N][M]; // <-- add this.
}