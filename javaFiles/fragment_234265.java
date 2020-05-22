List<JButton> btns = new ArrayList<>(); //store all the buttons here for 1 container

//Inside your MouseMove Event of your Panel (only 1)//

   checkPos(evt.x, evt.y);

//////////////////////////////

  private void checkPos(int mousePosX, int mousePosY){

  boolean minX;
  boolean minY;
  boolean maxX;
  boolean maxY;
  for (int i = 0; i < btns.size(); i++) {
    minX = mousePosX >= btns.get(i).getLocation().x;
    minY = mousePosY >= btns.get(i).getLocation().y;
    maxX = mousePosX <= (btns.get(i).getWidth()+ btns.get(i).getLocation().x);
    maxY = mousePosY <= (btns.get(i).getHeight()+ btns.get(i).getLocation().y);

    if (minX && minY && maxX && maxY){  //check if JButton exist on this location

        System.out.println(btns.get(i));  //return the JButton, Can be worked out for more precision
        //OR
        System.out.println("There's a JButton at this Location : " + mousePosX + " - " + mousePosY + " of the screen !");
    }

  }
 }