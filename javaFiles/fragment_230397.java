class Food {
    // [...]

    void update() {

        if( mouseX < xcord+10 && xcord < mouseX+10 &&
            mouseY < ycord+10 && ycord < mouseY+10) {

            xcord = int(random(width));
            ycord = int(random(height));
        }
    }

    // [...]
}