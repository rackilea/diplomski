final color RED = #D12020;
final color BLUE = #515DD8;
final color GREEN = #21AF20;
final color YELLOW = #F5EF74;
final color ORANGE = #F59219;
final color PURPLE = #B219F5;
final color WHITE = #FFFFFF;
final int ROWS = 12;
final int COLUMNS = 8;
final color[] colour = {RED, BLUE, GREEN, YELLOW, ORANGE, PURPLE, WHITE};
ArrayList <Square> picker, grid, answer;  //there are 3 groups of squared to manage

class Square{
  //modal variables
  private float xPos = 0;
  private float yPos = 0;
  private float myWidth = 0;
  private float myHeight = 0;
  public color myColor = color(0);  //myColor and isSelected are public because I want to access them directly from outside the class
  public boolean isSelected = false;  //public modal variables are not a popular choice, with good reasons, but for now let's just roll with it

  //this is a constructor. Every time you instantiate this class, you must call it's constructor. This one can be overloaded with the square's cordinates and size
  public Square(float xx, float yy, float ww, float hh) {
    xPos = xx;
    yPos = yy;
    myWidth = ww;
    myHeight = hh;
  }

  //you can call this method to make the square draw itself
  public void Render() {    
    if (isSelected) {
      stroke(RED);
    } else {
      stroke(167);
    }
      fill(myColor);
    rect(xPos, yPos, myWidth, myHeight);
  }

  //give coordinates to this function to know if this squared has been clicked on
  public boolean ClickedOn(float xx, float yy) {
    return ((xx > xPos && xx < xPos + myWidth) && (yy > yPos && yy < yPos + myHeight));
  }
}

//setup() is meant for you to initialize stuff before the main loop, which is draw()
void setup() {
  size(1000, 1000);
  InitializeSquares();
}

//let's initialize EVERYTHING SQUARE-SHAPED!
public void InitializeSquares(){
  float blockSize = width/20;
  float cornerX = width/12;
  float cornerY = height/8;
  float answerCornerX = cornerX * 6.5;
  float answerCornerY = cornerY;
  float pickerSize = blockSize * 1.5;
  float pickerCornerX = cornerX/2;
  float pickerCornerY = cornerY - (pickerSize * 1.5);

  //the grid:
  grid = new ArrayList <Square>();
  for (int i = 0; i<ROWS; i++) {
    for (int j = 0; j<COLUMNS; j++) {
      grid.add(new Square(cornerX + (j*blockSize), cornerY + (i*blockSize), blockSize, blockSize));
    }
  }

  //the target answer:
  answer = new ArrayList <Square>();
  for (int i = 0; i<ROWS; i++) {
    for (int j = 0; j<COLUMNS; j++) {
      answer.add(new Square(answerCornerX + (j*blockSize), answerCornerY + (i*blockSize), blockSize, blockSize));
      answer.get(answer.size()-1).myColor = colour[floor(random(colour.length))];
    }
  }

  //the color pickers
  picker = new ArrayList <Square>();
  for (int i = 0; i < colour.length; i++) {
    picker.add(new Square(pickerCornerX + (i*pickerSize), pickerCornerY, pickerSize, pickerSize));
    picker.get(picker.size()-1).myColor = colour[picker.size()-1];
  }
}

void draw() {
  background(0);  //it's ok, the squares will draw themselves

  //let's draw the player's squares
  for (Square s : grid) {
    s.Render();
  }
  for (Square s : grid) {
    //I'm drawing the selected squared over the unselected ones so we see them better
    if (s.isSelected) {s.Render();}
  }

  //drawing the answer grid
  for (Square s : answer) {
    s.Render();
  }

  //drawing the color pickers
  for (Square s : picker) {
    s.Render();
  }
}

void mouseClicked() {
  //checking if is the player selecting squares
  for (Square s : grid) {
    if (s.ClickedOn(mouseX, mouseY)) {
      s.isSelected = !s.isSelected;
    }
  }

  //checking if the player is coloring squares. If so, coloring the squared and unselecting them
  for (Square p : picker) {
    if (p.ClickedOn(mouseX, mouseY)) {
      for (Square s : grid) {
        if (s.isSelected) {
          s.isSelected = false;
          s.myColor = p.myColor;
        }
      }
    }
  }
}