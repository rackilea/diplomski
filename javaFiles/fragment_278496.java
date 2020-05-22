class Square{
  //modal variables
  private float xPos = 0;
  private float yPos = 0;
  private float myWidth = 0;
  private float myHeight = 0;
  public color myColor = color(0);  //myColor and isSelected are public because I want to access them directly from outside the class
  public boolean isSelected = false;  //public modal variables are not a popular choice, with good reasons, but for now let's just roll with it

  //this is a constructor. Every time you instantiate this class, you must call it's constructor. This one can be overloaded with the square's cordinates and size
  public Square(int xx, int yy, float ww, float hh) {
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