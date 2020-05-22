void keyPressed() {  
    if (key == 's' || key == 'S') {
        PImage img = createImage(posX, specSize, RGB);
        for(int i = 0; i < notes.size(); i++){
            int x = notes.get(i).getX();
            int y = notes.get(i).getY();
            int loc = x + y*posX;
            img.pixels[loc] = color(notes.get(i).getR(),
                           notes.get(i).getG(), notes.get(i).getB());
        }
        img.updatePixels();
        img.save("outputImage.png");
    }
}