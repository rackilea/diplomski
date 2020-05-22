int[][] interval = new int [15][5];

int intRow = 1;
int _START_ = 0;
int _END_ = 1;

interval[intRow][_START_] = 1;
interval[intRow][_END_] = 2;

for ( int row = interval[intRow][_START_]; row <= interval[intRow][_END_]; row++ ) {

    System.out.println(row);
}