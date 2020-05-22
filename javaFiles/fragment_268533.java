22c22
<     String[] players= new String[play];
---
>     String[] players= new String[par];
24c24
<     int scores[][]= new int[play-1][par-1];
---
>     int scores[][]= new int[play][par];
32c32
<     if (k==play)
---
>     if (k==par)
41,42c41,42
<         scores[j][i]=infile.nextInt();
<         System.out.println(scores[j][i]);
---
>         scores[i][j]=infile.nextInt();
>         System.out.println(scores[i][j]);