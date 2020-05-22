String result="";//this variable for the last line which print the result
   for (int i = 0; i < row; i++) {
     result=result+"Data Array "+i+" :";
       for (int j = 0; j < column; j++) {
         System.out.println("Row [" + i + "]:  Column " + j + " :");
         matrix[i][j] = sc.nextInt();
         result=result+matrix[i][j]+", ";

        }

    }
System.out.println(result);////for the final result