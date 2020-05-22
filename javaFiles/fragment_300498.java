// Create dummy class for holding coordinates
public class ButtonCordinates{

 public int x;
 public int y;

 public ButtonCordinates(int x, int y) {
     this.x = x;
     this.y = y;
 }
}

//In MainActivity class create a array for holding coordinates
ButtonCoordinates [] buttonsCoordinates = new ButtonCoordinates [10];    

int x = 0;
while(x < 10) {

  int Xposition = rnd.nextInt(width - buttonWidth);
  int Yposition = rnd.nextInt(height - buttonHeight);

  ButtonCoordinates buttonCoords = new ButtonCoordinates (Xposition,Yposition);

  if(!coordinatesFree(buttonCoords,buttonHeight,buttonWidth)){
    // Get another chance
    continue;
  }

  Button btn = new Button(this);
  btn.setX(Xposition);
  btn.setY(Yposition);

  btn.setWidth(buttonWidth);
  btn.setHeight(buttonHeight);
  btn.setText(Xposition+";"+Yposition);

  buttonsCoordinatesArray[x++] = buttonCoords;

  linearLayout.addView(btn);
  Log.d("Debug","Xpos =" + Xposition);
  Log.d("Debug","Ypos =" + Yposition);
}

// Method that prevents overlapping
private boolean coordinatesFree(ButtonCoordinates newButton, int buttonHeight, int buttonWidth){

     for(ButtonCoordinates existingButton : buttonsCoordinatesArray){
        if(existingButton == null){
            // First button ever
            return true;
        }

        boolean f1 = existingButton.x + buttonWidth <= newButton.x;
        boolean f2 = existingButton.y + buttonHeight <= newButton.y;
        boolean f3 = existingButton.x - buttonWidth >= newButton.x;
        boolean f4 = existingButton.y - buttonHeight >= newButton.y;

        if(!f1 && !f2 && !f3 && !f4){
            return false;
        }

    }
    return true;
}