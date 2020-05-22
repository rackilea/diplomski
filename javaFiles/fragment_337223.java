enum IntervalOrder implements Comparator<boundery> {
   INSTANCE;
   public int compare(boundery e1, boundery e2) {
     return e1.getStartInterval() .compareToIgnoreCase(e2.getStartInterval());
   }
};