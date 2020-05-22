public enum RPS {
   ROCK, PAPER, SCISSORS;

   public int test(RPS otherRps) {
      int[][] winMatrix = { 
            {  0, -1,  1 }, 
            {  1,  0, -1 }, 
            { -1,  1,  0 } };
      return winMatrix[ordinal()][otherRps.ordinal()];
   }
}