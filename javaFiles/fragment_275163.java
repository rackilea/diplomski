void draw() {

   counter=counter+1; 
   background(0,128,128);

   String coords = "(" + x + "," + y + ")";

  if (state == 1) {
     if(solutionExists) {
       textarea1.setText("Congratulations solution is possible  " + coords);       
     } else {
       textarea1.setText("Solution is not possible,enter other coordinates  " +coords);
     }

     return; 
  }

  if (state == 2) {
    readXY();
    return;
  }

  if (state == 3) {
    println("find solution for: " + coords);
    solutionExists = move(x,y,0);
    state = 1;
    return;
  }

}

public void readXY() {
  try {
   x = Integer.parseInt(textfield1.getText().trim());
   y = Integer.parseInt(textfield2.getText().trim());
   state = 3;
  } catch(Exception e) {
    state = 1;
  }

}