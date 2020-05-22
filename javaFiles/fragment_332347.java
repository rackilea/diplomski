String[] tmp = { Back[0][0], Back[1][0], Back[2][0] };

 // this logic only takes into account the changes that occur             
 for (int i = 0; i < 3; i++) {
     Back [i][0] = Under[i][0];
     Under[i][0] = Front[i][0];
     Front[i][0] = Top  [i][0];
     Top  [i][0] = tmp  [i];
 }