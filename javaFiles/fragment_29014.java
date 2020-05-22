void keyPressed() {  
    if (key == 's' || key == 'S') {
        PImage img = createImage(posX, specSize, RGB);
        for(??? note : notes ){
            int x = note.getX();
            int y = note.getY();
            int loc = x + y * posX;
            img.pixels[loc] = color(note.getR(), note.getG(), note.getB());
        }
        img.updatePixels();
        img.save("outputImage.png");
    }
}