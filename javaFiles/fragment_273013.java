class SummerStats
 {
   private int[][] salaries;

   public SummerStats()
   {

   }

   public void setSalaries(int people, int years)
   { 
      salaries = new int[people][years]; // initialize the array

   //rows respresent people and columns represent years
      for (people = 0; people < salaries.length; people++)
      {
         for (years = 0; years < salaries[people].length; years++)
         {
            salaries[people][years] = (int)(1000 + Math.random()*1000);
         }
      }

   }
    public void locateMax() {
        // Your code goes here. (You can access the salaries array)
    }
}