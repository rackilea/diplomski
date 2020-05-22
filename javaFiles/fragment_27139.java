class Enemy extends SpaceShip {  
  PImage img;

  Enemy(int xpos, int ypos) {
    x = xpos;
    y = ypos;
    //assuming sprite is inherited from SpaceShip ?
    sprite    = new String[5];
    sprite[0] = "1011101";
    sprite[1] = "0101010";
    sprite[2] = "1111111";
    sprite[3] = "0101010";
    sprite[4] = "1000001";
    //you are loading an image, but I see no use of the sprite
    img = loadImage("image.png");
  }

  void draw() {
    image(img, x, y);
  }

}