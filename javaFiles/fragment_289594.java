package org.junit;
public class Assert {
  public static void assertTrue(boolean b) {}
}

package test;
import static org.junit.Assert.assertTrue;
public class Test {
  void test() {
    int i;
    assertTrue((i = 1) == 1);
    assertTrue(i == 1);
  }
}