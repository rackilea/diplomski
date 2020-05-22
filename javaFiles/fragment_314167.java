int[][] id = {
  {1},
  {0, 1},
  {0, 0, 1},
  {0, 0, 0, 1},
  {0, 0, 0, 0, 1},
  {0, 0, 0, 0, 0, 1},
  {0, 0, 0, 0, 0, 0, 1},
};
TreeMap<IntBuffer, Integer> idAsMap = toMap(id);
System.out.println(idAsMap.size()+" non-zero values");
idAsMap.forEach((index,value)-> {
    for(int ix:index.array()) System.out.print("["+ix+']');
    System.out.println("="+value);
});