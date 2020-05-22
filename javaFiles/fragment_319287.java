public static boolean hasDuplicate(int[] array) {
      Set<Integer> dupes = new HashSet<Integer>();
      for (Integer i : array) {
          if (!dupes.add(i)) {
             return true; // we have found a duplicate
          }
      }
      return false; // no duplicate
}