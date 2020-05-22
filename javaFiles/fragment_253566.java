Random r = new Random(System.currentTimeMillis()); // change this seed value to a desired but reproducible number
int N = 5; // number of ships
for (int i = 0; i < N; i++) {
   int shipP = r.nextInt(10);
   if (shipP < 1) {
      // only 0 (10% probability)
      // ship = "AA";
   } else if (shipP < 4) {
      // works when 1, 2, 3
      // ship = "BBB";
   } else {
      // works when 4, 5 .. 9
      // ship = "CCCCC";
   }

   // generate orientation randomly (probability 0.5)
   boolean vertical = r.nextInt(2) == 0;

   // now find a suitable position in grid and place the ship.
}