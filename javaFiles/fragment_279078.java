int time;
int deadline; // initialize this somewhere in the start of your game

public void update(GameContainer container, int delta) {
    time += delta;
}

public void render(GameContainer container, Graphics g) {
    g.drawString("Time : " + time/1000, 100, 100);

    // if the current time has passed the deadline, do something
    if(time > deadline){
        int min = 2;
        int max = 3;
        deadline = time + ((min + (int)(Math.random() * ((max - min) + 1))) * 1000); // reset the interval timer

        // draw the image
        int x = 100;
        int y = getRandomNumberFromArray(); // this is the method I provided in my first part of the answer
        Image img = new Image("path/file.png");
        g.drawImage(img, x, y) // image file, x, y
    }
}