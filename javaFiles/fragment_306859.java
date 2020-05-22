int countX = bm.getWidth();
    int countY = bm.getHeight();

    int redCount = 0;

    for (int rangeX = 0; rangeX < countX; rangeX++) {
        for (int rangeY = 0; rangeY < countY; rangeY++) {
            int colorXY = bm.getPixel(rangeX, rangeY);

            int r = Color.red(colorXY);
            int g = Color.green(colorXY);
            int b = Color.blue(colorXY);

            if(Color.rgb(r,g,b) == Color.RED) {
                redCount++;
                /*bm.setPixel(rangeX,rangeY,Color.GREEN);*/
            }
        }
    }