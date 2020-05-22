for ( int i = 0; i < height/2; ++i ) {
    int k = height - 1 - i;
    for ( int j = 0; j < width; ++j ) {
        short temp = array[i * width + j];
        array[i * width + j] = array[k * width + j];
        array[k * width + j] = temp;
    }
}