while (iterator.hasNext()) {
    String s = iterator.next(); // here you store value returned by the iterator to make proper checks further
    System.out.println(s); // here you use created variable instead of calling next()
    if (s.equals("Nick") {, // again, created variable instead of next()
        iterator.remove(); // here you remove last value returned by the iterator
    }
}