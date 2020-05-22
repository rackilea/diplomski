public interface MyList extends List<String> {
  void foo();
}

MyList l = new ArrayList<String>();
l.foo();