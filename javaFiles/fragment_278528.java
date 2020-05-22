for (int x = 1; x < imageTwo.getWidth(); x++) {
  for (int y =1; y < imageTwo.getHeight(); y++) {
    if (equivalenceTable.keySet().contains(region[x][y])) {
      region[x][y] = equivalenceTable.get(region[x][y]);
    }  
  }
}