class MyComparator implements Comparator<Log> {
  public int compare(Log a, Log b) {
    if (a.getCountryCode().equals(b.getCountryCode()) {
      /* Country code is the same; compare by access type. */
      return a.getAccessType().ordinal() - b.getAccessType().ordinal();
    } else
      return a.getCountryCode().compareTo(b.getCountryCode());
  }
}
Collections.sort(logList, new MyComparator());