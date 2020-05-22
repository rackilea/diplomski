boolean exit = true;
while(rob.getPixelColor(594,718).getBlue()!=34 && exit){
   System.out.println("3 start queue");
   rob.delay(500);
   if((rob.getPixelColor(754,428).getBlue()>40) && (rob.getPixelColor(754,428).getRed()<30)){ 
      System.out.println("4 start queue");

      rob.delay(500);
      System.out.println("scanning for popup");

      rob.mouseMove(750,408);
      rob.delay(400);
      rob.mousePress(InputEvent.BUTTON1_DOWN_MASK);
      rob.delay(400);
      rob.mouseRelease(KeyEvent.BUTTON1_DOWN_MASK);
      rob.delay(400);
      exit = false;
   }                                
}