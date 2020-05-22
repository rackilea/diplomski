while (j < 10)
            {
              if (in.hasNextLine()){
               String line = in.nextLine();
               int num = Integer.parseInt(line);
               sum += num; //minor change here
              }
              else{
                 System.out.println("Not enough lines!");
                 break;
              }
              j++; //increment j
            }