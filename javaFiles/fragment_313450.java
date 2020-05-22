//iterate over every pixel..
for (int y = 0; y < image.getHeight(); y++) {
    for (int x = 0; x < image.getWidth(); x++) {
        //check if current pixel has maze colour
        if(isMazeColour(image.getRGB(x, y))){
            Rectangle rect = findRectangle(x, y);
            x+=rect.width;
        }
    }
}