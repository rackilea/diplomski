static final boolean flag = true;  // class attribute ...

  ...

  s: {
      if (flag) break s;
      System.out.println("I am not supposed to print this");
  }
  System.out.println("I am suppose to print this");