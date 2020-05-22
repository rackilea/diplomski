for(int row=0; row < votes.length; row++)
   {   
        int sum =0;
        for (int col=0; col < votes[row].length; col++)
         {
          sum = sum + votes[row][col];

        }
        fmt = new Formatter();
        fmt.format("%21d", sum);  
        System.out.print(fmt); // You are not printing newline after each vote..
   }