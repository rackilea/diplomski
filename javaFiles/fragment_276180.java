for(int allrbA=0; allrbA<4; allrbA++) {
   int r; 
   do {
      r = randoms1.nextInt(10);   // get a random number
   } while (r == load4G);         // until it is different

   selectrb[allrbA].setText("" + r);
}