final int col = 10;
final int row = 10;
final int boxSize = 30;

final color selectedBoxColor = color(90);
final color boxColor = color(50);

//int colors = 50; //use the array instead

//rectangle variables
int x;
int y;

//arrays starts at zero, but are initialized at their "normal" number
int [][] boxes = new int [col][row];
color [][] boxesColor = new color [col][row];

void settings() {
  //this should be here
  size(col * boxSize, row * boxSize);
}

void setup(){
  for(int i = 0; i< boxes.length; i++){
    for(int j = 0; j < boxes[i].length; j++){
        boxes[i][j] = j;
        boxesColor[i][j] = boxColor;
    }
  }
}
void draw(){
 for(int i = 0; i< boxes.length; i++){
    for(int j = 0; j < boxes[i].length; j++){
      x = i * 30;
      y = j * 30;

      fill(boxesColor[i][j]);
      stroke(0);
      rect (x, y, boxSize, boxSize);
    }
  }

}
void mousePressed(){
  //using basic math to know which box was clicked on and changing only this box's color
  boxesColor[mouseX / boxSize][mouseY / boxSize] = selectedBoxColor;

  //no need for these lines
   //for(int i = 0; i< boxes.length; i++){
   // for(int j = 0; j < boxes[i].length; j++){      
   //   colors = 90; 
   //   fill(colors); 
   // }
   //}
}