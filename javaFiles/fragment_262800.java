class DatedComparator implements Comparator<Dated> {
  @Override
  public int compare(Dated o1, Dated o2) {
    return o1.getDate().compareTo(o2.getDate());
  }
}