int MAX_MATRIX = 1024;
int NUM_THREADS = 4;
int start_row = 0, end_row = 0, start_column = 0, end_column = 0;
for (int i = 0; i < NUM_THREADS/2; i++){
    start_row = i*MAX_MATRIX/2;
    end_row = start_row + MAX_MATRIX/2;
    for (int j = 0; j < NUM_THREADS/2; j++){
        start_column = j*MAX_MATRIX/2;
        end_column = start_column + MAX_MATRIX/2;
        System.out.println(start_row + "," + end_row + "," + start_column + "," + end_column);
    }
}