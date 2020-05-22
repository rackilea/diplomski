public static void main(String[] args) throws FileNotFoundException {
   Scanner sc = new Scanner(new BufferedReader(new FileReader("reels_template.txt")));

   int arrX = 77;
   int arrY = 4;
   String [][] arr = new String[arrX][arrY];
   String[] line = {};

   sc.nextLine();  // remove the first line from the scanner

   for (int i=0; i<arrX; i++) {
     if (sc.hasNextLine())
       line = sc.nextLine().trim().split("\\s+");

       for (int j=0; j<arrY; j++) {        
         arr[i][j] = line[j+1] + " "; //always skips first element of 'line'                           
       }
    }


    for (int i = 0; i < arrX; i++) {
      for ( int j = 0; j < arrY; j++) 
        System.out.print(arr[i][j]);

      System.out.println();
    }

}