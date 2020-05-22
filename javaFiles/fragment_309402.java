Collections.sort(setters, new Comparator<Method> {
  @Override
  public int compare(Method a, Method b) {
    return a.getName().compareTo(b.getName());
  }
});