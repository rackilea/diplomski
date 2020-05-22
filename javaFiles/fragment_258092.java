Set<Integer> possible = new HashSet<>();

// ...

for(int row = 0; row < size; row++){
   for(int col = 0; col < size; col++){
       // ...
       grid[row][col].possible = possible;
   }
}