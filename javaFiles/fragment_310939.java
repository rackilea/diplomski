Arrays.sort(my_array_list, new Comparator<String>() {

  private static final String FIRST = "ALL";

  @Override
  public int compare(String o1, String o2) {
    if (o1.equals(FIRST)) {
      return -1;
    } else if (o2.equals(FIRST)) {
      return 1;
    } else {
      return o1.compareTo(o2);
    }
  }
});