Comparator<String> yeOldeComparator = new Comparator<String>() {
  @Override public int compare(String a, String b) {
    int cmpFirst = Integer.compare(a.charAt(0), b.charAt(0));
    if (cmpFirst != 0) return cmpFirst;

    return Integer.compare(b.length(), a.length());
  }
};