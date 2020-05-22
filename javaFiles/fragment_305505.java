for (int i = 0; i<x-3; i++)
   for (int j=0; j<y-3; j++)
      for (int ki = i; ki<3; ki++)
         for(int kj = j; kj<3; kj++)
             //ki, kj at most between 0 and 2
             img.getRGB(ki, kj)