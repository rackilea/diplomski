for (int j=1;j<=t.length;j++) { //use <= instead of <
    for (int i=1;i<=s.length;i++) { //use <= instead of <
       if (s[i-1] ==t[j-1]) //use i-1 and j-1 
         d[i][j] = Math.min(Math.min(d[i-1][j]+1,d[i][j-1]+1),d[i-1][j-1]); //use the correct update
       else
         d[i][j] = Math.min(Math.min(d[i-1][j]+1,d[i][j-1]+1),d[i-1][j-1]+1);
    }
}