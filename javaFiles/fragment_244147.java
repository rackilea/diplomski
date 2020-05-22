for(int x = 0; x< 22; x++) {     // for every array in outer array
     for(int y = 0; y < 9; y++)  {   //for every double in each inner array

          numbers[x][y] = (int)(Math.random()*192)+1;
          System.out.print(numbers[x][y]+ "  ");     
      }
 System.out.println(); 

}