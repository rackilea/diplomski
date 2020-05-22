int total = 0;
for (int x=0;x<scale;x++) {
    for (int y=0;y<scale;y++) {
        total += image[i*scale+x][j*scale+y];
    }
}