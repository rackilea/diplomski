outer: for (int i = 0; i < 5; i++) {
   inner : for (int j = 0; j < 5; j++) {
       if (i + j == 9) { 
           break outer;
       }
   }
}