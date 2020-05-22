int counter = 0;
 for (int i =0; i < table.length; i++){
     if (table[i][0] == win[0][0] && table[i][1] == win[0][1] && table[i][2] == win[0][2])
     {
          counter++;
          System.out.println("Person " + i);
     }
 }

 System.out.println("There were " + counter + " winners.");