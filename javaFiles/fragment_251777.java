public void modify(int newX, int y, int width, int h) {
    int x = newX;  // the value isn't saved to the class members
    this.y = y; // this is saved, hence you see the change in the y value
    width = width; // meaningless, the variable is overwritten with it's own value
    this.height = height; // who is height? the function receives h
}