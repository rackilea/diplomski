int[][] reduceImage(int[][] image, int scale) {

    int[][] reducedImage = new int[image.length/scale][image[0].length/scale];

    for (int i=0;i<reducedImage.length;i++) {
        for (int j=0;j<reducedImage[0].length;j++) {
            int total = 0;
            for (int x=0;x<scale;x++) {
                for (int y=0;y<scale;y++) {
                    total += image[i*scale+x][j*scale+y];
                }
            }
            reducedImage[i][j] = total>(scale*scale/2) ? 1 : 0;
        }
    }

    return reducedImage;
}