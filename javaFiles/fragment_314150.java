new Comparator<String>() {
  @Override
  public int compare(String s1, String s2) {
    return getSortOrder(s1) - getSortOrder(s2);
  }
}