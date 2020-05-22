for(int c=0; c < 3; c++) {
       colSum[c]+=votes[s][c]; // <-- new line to do the column sum
       fmt = new Formatter();
       fmt.format("%12d", votes[s][c]);
       System.out.print(fmt);
   }