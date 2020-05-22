void setup(){
  noSmooth();
  scale(10);

  Enemy e = new Enemy(0,0);
  e.draw();
}

PImage fromBinaryStrings(String[] sprite){
  //determine height: number of lines
  int h = sprite.length;
  //determine width: length of a line
  int w = sprite[0].length();
  //create an image
  PImage result = new PImage(w,h,RGB);
  //traverse rows
  for(int y = 0 ; y < h; y++){
    //access row string
    String row = sprite[y];
    //traverse cols
    for(int x = 0; x < w; x++){
      //check each char's value and set the color accordingly
      if(row.charAt(x) == '1'){
        result.set(x,y,color(255));
      }else{
        result.set(x,y,color(0));
      }
    }
  }

  return result;
}
class SpaceShip{
  int x,y;
  String[] sprite;
}
class Enemy extends SpaceShip {  
  PImage img;

  Enemy(int xpos, int ypos) {
    x = xpos;
    y = ypos;

    sprite    = new String[5];
    sprite[0] = "1011101";
    sprite[1] = "0101010";
    sprite[2] = "1111111";
    sprite[3] = "0101010";
    sprite[4] = "1000001";

    img = fromBinaryStrings(sprite);
  }

  void draw() {
    image(img, x, y);
  }

}