public static void displayCounts(int[] counts){
  for(int i = 0; i < counts.length; i++){
    if(counts[i] > 0){
      System.out.println(i + " occurs " + counts[i] + " times");
    }
  }
}