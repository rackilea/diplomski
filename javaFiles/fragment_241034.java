public <T> T max(List<T> list, Comparator<T> comp) {
   T biggestSoFar = list.get(0);
   for ( T t : list ) {
       if (comp.compare(t, biggestSoFar) > 0) {
          biggestSoFar = t;
       }
   }
   return biggestSoFar;
}