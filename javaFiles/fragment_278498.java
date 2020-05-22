final color RED = #D12020;
final color BLUE = #515DD8;
final color GREEN = #21AF20;
final color YELLOW = #F5EF74;
final color ORANGE = #F59219;
final color PURPLE = #B219F5;
final color WHITE = #FFFFFF;
final int ROWS = 12;
final int COLUMNS = 8;
final int BLOCK_SIZE = 40;
int blockSize;
int spacing;
int cornerX;
int cornerY;
int size;
int space;
int cell = -1;
int col = -1;
int row = -1;
color[] colour = {RED, BLUE, GREEN, YELLOW, ORANGE, PURPLE, WHITE};

//I added these variables. The color array is 2 dimentional, so you can use it like if it had grid coordinates (square [0][2] is third on the first line)
PVector square_selected;  //this will hold the grid coordinates of the currently selected square, or -1 for "nothing"
color[][] square_color;
int columnSelected = -1;
int rowSelected = -1;

void setup() {
  size(1000, 1000);
  background(0);
  cornerX = width/8;
  cornerY = height/8;
  size = height/33;
  space = width/100;
  targetImage();

  //initializing the new array
  square_color = new color[COLUMNS][ROWS];
  for (int i=0; i<COLUMNS; i++) {
    for (int j=0; j<ROWS; j++) {
      square_color[i][j] = color(0);
    }
  }
  square_selected = new PVector(-1, -1);

  //You might have heard about this or not, but as a general rule global variables are shunned upon. That's because when the program becomes more complex, they become exponentially harder to control,
  //and can cause unexpected behavior. No joke, Toyota programmers actually caused death because of these (search for "Toyota spaghetti code" if you're curious)
  //So I'm initializing these here and removing the places where the code would change them unexpectedly.
  //You may have had a better idea of what you're doing that I do, though, so you can chalk up this decision to my coding preferences.
  blockSize = width/20;
  spacing = width/200;
}

void draw() {
  background(0);
  grid();
  colourCells();
  //selectCell();
  columnSelectors();
  rowSelectors();
  counter();
}

//draws the colour selectors
void colourCells() {
  int colourBlocks = 7;
  int squareX = blockSize;
  for (int i=0; i < colourBlocks; i++) {
    stroke(167);
    fill(colour[i]);
    rect(squareX, 0, blockSize, blockSize);
    squareX += spacing+blockSize;
  }
}

//draws the grid
void grid() {
  for (int i=0; i<ROWS; i++) {
    for (int j=0; j<COLUMNS; j++) {
      stroke(167);
      fill(square_color[j][i]);
      rect(cornerX + (BLOCK_SIZE * j), cornerY + (BLOCK_SIZE * i), BLOCK_SIZE, BLOCK_SIZE);
    }
  }
  //drawing the selected square over the others
  if (square_selected.x > -1) {
    stroke(RED);
    fill(square_color[(int)square_selected.x][(int)square_selected.y]);
    rect(cornerX + (BLOCK_SIZE * (int)square_selected.x), cornerY + (BLOCK_SIZE * (int)square_selected.y), BLOCK_SIZE, BLOCK_SIZE);
  }
}

//creates the circular column selectors
void columnSelectors() {

  int columnX = (cornerX) + (size/2) + (space/2);
  int columnY = (cornerY) - (size/2) - space;

  noFill();
  for ( int i = 0; i<COLUMNS; i++) {
    if (i == columnSelected) {
      stroke(RED);
    } else {
      stroke(167);
    }
    ellipse(columnX, columnY, size, size);
    columnX += size + space;
  }
}

//creates the circular row selectors
void rowSelectors() {

  int rowX = (cornerX) - (size/2) - space;
  int rowY = (cornerY) + (size/2) + (space/2);
  noFill(); 

  for ( int j = 0; j<ROWS; j ++) {
    if (j == rowSelected) {
      stroke(RED);
    } else {
      stroke(167);
    }
    ellipse(rowX, rowY, size, size);
    rowY += size + space;
  }
}

//creates the score counter at the bottom of canvas
void counter() {
  float x = width/3;
  float y = 4*height/5;
  float boxLength = width/3;
  float boxHeight = height/20;
  int counter = 0;
  fill(255);
  rect(x, y, boxLength, boxHeight);
  String counterText = "Num Moves: " + counter;
  fill(0);
  textSize(40);
  text(counterText, x + (boxLength*1/14.0), y + (boxHeight*3/4.0));
}

//loads in a random target image
void targetImage() {
  float y = height/5;
  float x = width/2;
  String [] file = {"target0.png", "target1.png", "target2.png", "target3.png", "target4.png"};
  PImage target;// create a variable that can point to an off-screen buffer
  String filename = file[int(random(0, 4))]; //"target" + int(random(0,4)) + ".png";// create filename
  target = loadImage(filename);// load image file into off-screen buffer
  //image(target, x, y, width/3.125, height/2.08);// display the buffer on canvas at location x, y
}

//allows the user to select/deselect a column
int selectColumn() {
  int x;
  int xPos= mouseX - cornerX;
  x = xPos/(size+space);
  if (x == col)
    return -1;
  else
    return x;
}

//allows the user to select/deselect a row
int selectRow() {

  int y;
  int yPos= mouseY - cornerY;
  y = yPos/(size+space);
  if (y == row)
    return -1;
  else
    return y;
}

//mouse click functions for selecting cells/rows/columns/colour
void mouseClicked() {
  //user is clicking inside the grid
  if (mouseX > cornerX && mouseY > cornerY && mouseX < cornerX + COLUMNS*BLOCK_SIZE 
    && mouseY < cornerY + ROWS*BLOCK_SIZE) {
    //cell = cellSelected();
    square_selected.x = floor((mouseX - cornerX)/BLOCK_SIZE);
    square_selected.y = floor((mouseY - cornerY)/BLOCK_SIZE);
  }

  //user is selectong a column
  if (mouseX > cornerX && mouseY > (cornerY - (space + size)) && mouseX < cornerX + COLUMNS*BLOCK_SIZE 
    && mouseY < cornerY) {
    if (columnSelected == selectColumn()) {
      columnSelected = -1;
    } else {
      columnSelected = selectColumn();
    }
  }

  //user is selecting a row
  if (mouseX > (cornerX - (space + size)) && mouseY > cornerY && mouseX < cornerX 
    && mouseY < cornerY + ROWS*BLOCK_SIZE) {
    if (rowSelected == selectRow()) {
      rowSelected = -1;
    } else {
      rowSelected = selectRow();
    }
  }

  //user is picking a color
  if (mouseY < blockSize) {
    //validating the color
    for (int c = 0; c < colour.length; c++) {
      if (get(mouseX, mouseY) == colour[c]) {
        //if a square has been selected
        if (square_selected.x > -1) {
          square_color[(int)square_selected.x][(int)square_selected.y] = colour[c];
          square_selected = new PVector(-1,-1);
        }

        //if a row has been selected
        if (rowSelected > -1) {          
          for (int i = 0; i < COLUMNS; i++) {
            square_color[i][rowSelected] = colour[c];
          }
          rowSelected = -1;
        }

        //if a column has been selected
        if (columnSelected > -1) {          
          for (int i = 0; i < ROWS; i++) {
            square_color[columnSelected][i] = colour[c];
          }
          columnSelected = -1;
        }
        break;
      }
    }    
  }
}