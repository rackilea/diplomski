performOperation(int[] counters) {
    String counterAsString = "";
    for (int level = 0; level < counters.length; level++) {
        counterAsString = counterAsString + counters[level];
        if (level < counters.length - 1) counterAsString = counterAsString + ",";
   }
   System.out.println(counterAsString);
}