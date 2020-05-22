boolean failed = false;
for (int i = 0; i < grading.length; i++)
      {
         if (failed)
             scan.nextLine();

         failed = false;

         if (scan.hasNextInt()) {

             int x = scan.nextInt();
             if(x >= MIN && x <= MAX)
             {
             grading[i] = x;
             } else {
             System.out.println("Grade must be from 0-100!");
             i--;
             continue;
             }

         } else {
          // jump back to the start of this iteration of the loop and re-prompt
          i--;
          System.out.println("Number must be an int!");
          failed = true;
          continue;
         }
      }