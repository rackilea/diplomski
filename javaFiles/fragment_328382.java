public void readFile(){        
  for(int i = 0; i < 14; i++){
    if (! m.hasNext()) {
      // Alert the user!
      System.err.println("The map file stopped at entry: " + i);
      break;
    }
    map[i] = m.next();
  }
  // to help in debugging.
  System.out.println("The map is: " + java.util.Arrays.toString(map));
}