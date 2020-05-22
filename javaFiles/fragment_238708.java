for (int x = 0; x < scaledImageWidth; x++) {
    for (int y = 0; y < scaledImageHeight; y++) {
            imageTL.setRGB (x, y, scaledImagePixels[x][y]);
            imageTR.setRGB (x + scaledImageWidth, y, scaledImagePixels[x][y]);
            imageBL.setRGB (x, y + scaledImageHeight, scaledImagePixels[x][y]);
            imageBR.setRGB (x + scaledImageWidth, y + scaledImageHeight, scaledImagePixels[x][y]);
    }
}