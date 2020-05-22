for (int r = 0; r < image1.length; r++) {
    for (int c = 0; c < image1[r].length; c++) {
        pixArray[r*image1[0].length+c][0] = image1[r][c];
    }
}

 for (int r = 0; r < image2.length; r++) {
    for (int c = 0; c < image2[r].length; c++) {
        pixArray[r*image2[0].length+c][1] = image2[r][c];
    }
}