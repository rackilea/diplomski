BufferedImage image = new BufferedImage(inputWidth, inputHeight, BufferedImage.TYPE_INT_ARGB);
        int[] rgbRaster = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();

        for(int i = 0; i < inputHeight; i++) {
            for(int j = 0; j < inputWidth; j++) {
                int index = (inputWidth  * i) + j;
                rgbRaster[index] = SOME_ARG_VALUE;
                }
            }
        }