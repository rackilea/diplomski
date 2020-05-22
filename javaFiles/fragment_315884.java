if (direction.equals("NORTH")) {
   if (g.isWhite(xPos, yPos)) {
      g.setBlack(xPos, yPos);
      setDirection("WEST");
      xPos--; //move West
   } else {
      g.setWhite(xPos, yPos);
      setDirection("EAST");
      xPos++; //move East
   }
} //...