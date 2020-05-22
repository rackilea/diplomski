//for(int row=0; row < votes.length; row++) // Remove this loop
   //{ // Remove this

        int sum =0;
        for (int col=0; col < votes[s].length; col++)
         {
          sum = sum + votes[s][col];

        }
        fmt = new Formatter();
        fmt.format("%21d", sum);  
        System.out.print(fmt);
   //} // Remove this also..