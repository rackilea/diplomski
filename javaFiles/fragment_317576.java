public void foo(String... ss) {
    System.out.println(ss[0]);
}

    foo(null); // causes NullPointerException
    foo((String) null); // prints "null"