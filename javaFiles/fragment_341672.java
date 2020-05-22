static class foo{

  }

  static class bar{

  }

  public static void main(String[] args) {
    ArrayList<Object> a = new ArrayList<>();
    a.add(new foo());
    a.add(new bar());

    for (Object o: a) {
      if(o.getClass() == foo.class){
        a.remove(o);
      }
    }
  }