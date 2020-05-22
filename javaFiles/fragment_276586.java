class GridArrayComparator implements Comparator<Grid[]> {
   public int compare(Grid[] grids1, Grid[] grids2) {
       if (grids1.length > 0 && grids1.length > 0) {
           return grids1[0].compareTo(grids2[0]);
       } else if (grids1.length > 0) {
           return 1;
       } else if (grids2.length > 0) {
           return -1;
       } else {
           return 0;
       }
   }
}