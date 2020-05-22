@Override public int compareTo(Ticket t) {
   int v;

   v = this.boeking.compareTo(t.boeking);
   if (v != 0) return v;

   v = compareInt(this.rijNr, t.rijNr);
   if (v != 0) return v;

   v = compareInt(this.stoelNr, t.stoelNr);
   if (v != 0) return v;

   v = compareInt(this.ticketType, t.ticketType);
   if (v != 0) return v;

   return 0;
}
private static int compareInt(int i1, int i2) {
   if (i1 < i2) {
     return -1;
   } else if (i1 > i2) {
     return +1;
   } else {
     return 0;
   }
}