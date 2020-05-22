// in this sample my image is 5*4 (5*4 - 2048*2048)
   for (int i = 0; i < 5; i++) {
        for (int j = 0; j < 4; j++) {
              batch.draw(texture[i,j], i*2048, j*2048, width, height);
        }
    }