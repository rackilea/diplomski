List<Emp> results = ...;
Emp max = Collections.max(results, new Comparator<Emp>() {
  int compare(Emp a, Emp b) {
    return Float.compare(a.getSalary(), b.getSalary());
  }
});