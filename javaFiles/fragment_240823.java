void method(String y) {
    y = "bar"; // This doesn't change x.
}
...

String x = "foo";
method(x);
System.out.println(x); // foo