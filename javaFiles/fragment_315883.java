if (direction.equals("NORTH")) {
   // This section decides which way ant will go based on the current cell
   if (g.isWhite(xPos, yPos)) {
      g.setBlack(xPos, yPos);
      setDirection("WEST");
   } else {
      g.setWhite(xPos, yPos);
      setDirection("EAST");
   }
   // This section move north, not in the direction the ant turns.
   yPos++;
} //...