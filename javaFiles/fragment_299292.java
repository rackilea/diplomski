for (int x = 0; x < width; x++) {
    for (int y = 0; y < height; y++) {
        int index = 0;
        for (int filterX = -filterWidth / 2; filterX < filterWidth / 2; filterX++) {
            for (int filterY = -filterHeight / 2; filterY < filterHeight / 2; filterY++) {
                A = (pixels[x+filterX+width*(y+filterY)])>>24 & 0xFF;
                R = (pixels[x+filterX+width*(y+filterY)] >> 16) & 0xFF;
                G = (pixels[x+filterX+width*(y+filterY)] >> 8) & 0xFF;
                B = pixels[x+filterX+width*(y+filterY)] & 0xFF;
                ...
            } 
        }
    }
 }