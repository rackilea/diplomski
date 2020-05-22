private static class ValueComparator implements Comparator<Entry<String, FullName>> {

  @Override
  public int compare(Entry<String, FullName> e1, Entry<String, FullName>> e2) {
    FullName fullName1 = e1.getValue();
    FullName fullName2 = e2.getValue();
    return fullName1.getName().getFirstName()
           .compareTo(fullName2.getName().getFirstName());
  }
}