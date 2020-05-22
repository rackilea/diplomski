boolean conflicts_exist = true;
while (conflicts_exist) {
   conflicts_exist = false;
   for (int k = 1; k < n; k++) {
      if (k != me && level[k] >= i && victim[i] == me) {
         conflicts_exist = true;
         break;
      }
   }
}