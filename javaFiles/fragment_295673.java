Collections.sort(list, new Comparator<Class1>() {
  public int compare(Class1 c1, Class1 c2) {
    if (c1.soc > c2.soc) return -1;
    if (c1.soc < c2.soc) return 1;
    return 0;
  }});