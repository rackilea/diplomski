package com.example.foo;
public class Foo {
    public native static void eyeDetection(long addrRgba);
    static void getCoord(int x, int y) {
      System.out.println("got coordinates: " + x + ", " + y);
      // consume the coordinates in Java, e.g.
      Foo2.onCreate(x, y);
    }
}