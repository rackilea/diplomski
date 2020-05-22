1  public List<? extends Foo> getFoos()
2  {
3    List<Foo> foos = new ArrayList<Foo>(); /* Or List<SubFoo> */
4    foos.add(new SubFoo());
5    return foos;
6  }