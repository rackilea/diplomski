static <T> List<Integer> indexesOf(List<T> source, T target)
  {
     final List<Integer> indexes = new ArrayList<Integer>();
     for (int i = 0; i < source.size(); i++) {
       if (source.get(i).equals(target)) { indexes.add(i); }
     }
     return indexes;
  }