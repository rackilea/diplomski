public static void main(String[] args) 
{ 
   Scanner scan = new Scanner(System.in); 
   double[] rainfall; 
   int curyear = 0;
   double totalRainfall = 0.0; 
   double max = 0, min  = 0;
   int year = 0;
   int maxQuarter = 1;
   int minQuarter = 1;

   // Prompt user for the number of years
   System.out.println("Enter the number of years: ");
   year = scan.nextInt();
   rainfall = new double[year*4];
   for (int i=0; i < year*4 + 1; i++) 
   { 
       if((i % 4) == 0 && i != 0)
       {
            System.out.println();
            System.out.println("YEAR: " + ++curyear );
            System.out.println("Total rainfall = "+totalRainfall); 
            System.out.println("Average rainfall = "+(totalRainfall / 4.0)); 
            System.out.println("Max quarter rainfall = "+ max);
            System.out.println("Min quarter rainfall = " + min);
            System.out.println("Max quarter rainfall = "+ maxQuarter);
            System.out.println("Min quarter rainfall = " + minQuarter);
            System.out.println();
            if(i == (year*4))
                break;
       }

      System.out.print("Enter rainfall for quarter " + (i+1) + ": "); 
      rainfall[i] = scan.nextDouble(); 
      totalRainfall += rainfall[i]; 
      if (i == 0)
      {
         max = min = rainfall[i];
      }

      {
         if (rainfall[i] > max) {
            max = rainfall[i];
            maxQuarter = i + 1;
         }
         if (rainfall[i] < min) {
            min = rainfall[i];
            minQuarter = i + 1;
         }
      }


  }



}//end main