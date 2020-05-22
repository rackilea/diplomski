public static void populateRandom() {
Random randomGenerator = new Random();
for(int row = 0; row < grid.length; row++) {
      for(int column=0; column < grid[row].length; column++) {
         int randomIndex = randomGenerator.nextInt(5); 
         grid[row][column] = options[randomIndex]);
      }
   }
}