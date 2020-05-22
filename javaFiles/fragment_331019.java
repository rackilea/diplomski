package com.aop.example;

public class LibClass {

  public LibClass() {
    packagePrivateMethod();
  }

  void packagePrivateMethod() {
    // <-- here I want to execute additional code
    System.out.println("In packagePrivateMethod");
  }
}