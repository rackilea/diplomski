List<Integer> indices;
Collections.sort(indices, new Comparator<Integer>() {
   public int compare(Integer a, Integer b) {
      //todo: handle null
      return b.compareTo(a);
   }
}