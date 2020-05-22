class ShapeDrawer {
    private RandomFunTester random = new RandomFunTester(); 

    void drawRandomShape() {
        int randNumber = random.nextInt(2) + 1; 

        switch (randNumber) {
          case 1: 
            random.drawHouse(); 
            break; 
          case 2: 
            random.drawSquare(); 
            break; 
          case 3: 
            random.drawCircles(); 
            break; 
          default: 
            System.out.println("The random number generated is not "
                               + "between the values of 1 and 3."); 
        }
    }
}