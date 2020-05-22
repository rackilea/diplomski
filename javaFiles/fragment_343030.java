String[] lines = new String[20];
          //if you want to store more lines increase the size of the array
          int j = 0;
          //manage below while loop condition j < 20 based on array size and change the 
          //number from 20 to that number. For example if array size 50 make j < 50
          while (sc.hasNextLine() && j < 20) {
                    String line = sc.nextLine();
                if(line.contains("blablbal") {
                   int i = 0;
                   while(sc.hasNextLine() && i < 5){
                     line = sc.nextLine();
                     if(line.contains("blablbal") {
                        continue;
                     }
                     lines[j++] = line;
                     i++;
                     if ( j >= 20 )//change this according to the size of array as well
                        break;
                   }
                 }