int subXStart = max(x-3, 0);
int subYStart = max(y-3, 0);
int subXEnd = min(x+4, img.getWidth() - width);
int subYEnd = min(y+4, img.getHeight() - height);
for (int subX = subXStart; subX < subXEnd; subX++) {
    for (int subY = subYStart; subY < subYEnd; subY++) {
        counter++;
        testingImage = img.getSubimage(subX, subY, width, height);
        // run your neural net
    }
}