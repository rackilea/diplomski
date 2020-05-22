public static void tableOut(int[] gradeList, int[] devList, int avg)
        {  

           System.out.println("\tStudent\tGrade\tDeviation");

           for (int i = 0; i < nameList.length; i++)
           {   
              System.out.print("\t" + nameList[i] +  "\t");
              System.out.print("\t" + gradeList[i] + "\t");
              System.out.printf("\t" + "%7d", devList[i]); 
              System.out.println();
           }
           System.out.println("The average grade was " + avg + ".");


           int[][] outTable = new int[7][2];

           for (int row = 0; row < nameList.length; row++)
           {
              for (int col = 0; col <2; col++)
              {
                 outTable[row][col] = 21;

              }
           }
        }