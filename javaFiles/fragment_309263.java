private void timeConvert(int[] times, String[] names) {
    for (int time : times) {
      int hours = time / 60; //since both are ints, you get an int
      int minutes = time % 60;
      System.out.printf("%d:%02d\n", hours, minutes);
    }
  }