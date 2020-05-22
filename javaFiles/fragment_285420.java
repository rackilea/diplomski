for (Block[] row : table) {
   Set set = new HashSet<Block>(); 
   for (Block cell : row) {
      set.add(cell);
   }
   if (set.size() < 6) { //has duplicate
   }
}