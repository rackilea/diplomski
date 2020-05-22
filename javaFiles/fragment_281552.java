package com;

public final class GenericImpl {
  public static <T extends MyClass & MyInterface> MyOtherClass someMethod(T type) {
  }
}