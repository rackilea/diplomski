for(int allrbA=0; allrbA<4; allrbA++) {
   int r = randoms1.nextInt(10 - 1); // range one less because one will be skipped
   if (r == load4G) r = 9;           // don't want this one, take the one
                                     // that would have been included in the full range

   selectrb[allrbA].setText("" + r);
}