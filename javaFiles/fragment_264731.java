int _i = 10;
int _j = 10;
String[][] array = new String[_i][_j];
for (int i = 0; i < _i; i++) {
    for (int j = 0; j < _j; j++) {
        if(i==0 || j == 0 || i == _i-1|| j == _j-1){
            array[i][j] = "*";
        }
    }
}