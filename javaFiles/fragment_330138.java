Image image = new javaxt.io.Image(bufferedImage);

    // skew image
    image.setCorners(
            // keep the upper left corner as it is
            0,0, // UL

            // push the upper right corner more to the bottom
            image.getWidth(),20, // UR

            // push the lower right corner more to the left
            image.getWidth()-45,image.getHeight(), // LR

            // push the lower left corner more to the right
            55,image.getHeight()); // LL

    // crop image
    image.crop(80, 105, image.getWidth()-150, image.getHeight()-105);