public void a(String s) {
    synchronized(this) {
      listOne.add(s);
    }
  }

  public void b(String s) {
    synchronized(this) {
      listTwo.add(s);
    }
  }

  public void c(String s) {
      listOne.add(s);
  }

  public void d(String s) {
      synchronized(listOne) {
        listOne.add(s);
      }
  }