Double imageLayer[][] = vtkLayers.get(layer);

        // Initialize BufferedImage, assuming Color[][] is already properly populated.
        BufferedImage bufferedImage = new BufferedImage(imageLayer.length, imageLayer[0].length,
                BufferedImage.TYPE_INT_RGB);

        // Set each pixel of the BufferedImage to the color from the Color[][].
        for (int x = 0; x < imageLayer.length; x++) {
            for (int y = 0; y < imageLayer[x].length; y++) {
                Color test = doubleToColor(imageLayer[x][y], 4080);

                bufferedImage.setRGB(x, y, test.getRGB());
            }
        }

        try {
            File imageFile = new File(path);
            ImageIO.write(bufferedImage, "png", imageFile);
        }
        catch (Exception e){
            System.out.println("Failed to create image");
        }