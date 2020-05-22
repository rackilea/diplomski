public Object max(List list, Comparator comp) {
   Object biggestSoFar = list.get(0);
   for ( Object  t : list ) {
       if (comp.compare(t, biggestSoFar) > 0) {  //IMPORTANT
          biggestSoFar = t;
       }
   }
   return biggestSoFar;
}