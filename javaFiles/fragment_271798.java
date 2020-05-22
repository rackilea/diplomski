int x = 32; // Dimensions of icons
int y = x;
int posX = 100;
int posY = 100;

for (int pos = 0; pos < icons.getIcon().size(); pos++) {
    if(pos % 10 == 0) {
        posY += y + 10;
        posX = 100; // Returns posX back to the left-most position
        icons.getIcon().get(pos).paintIcon(canvas, graphics, posX, posY);
    } else {
        icons.getIcon().get(pos).paintIcon(canvas, graphics, posX, posY);
    }
    posX += x + 10; // Do that out of the if, so that posX is incremented either way
}