LinkedList<Species> sorted = new LinkedList<Species>(arg);
Collections.sort(sorted, new Comparator<Species>() {
  @Override
  public int compare(Species s1, Species s2) {
      return s1.getName().compareTo(s2.getName());
  }
});