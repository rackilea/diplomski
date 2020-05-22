package de.scrum_master.app;

import org.android10.gintonic.annotation.MyAnnotation;

public class Application {
  @MyAnnotation
  public void myMethod() {
    System.out.println("Hi there!");
  }

  public static void main(String[] args) {
    new Application().myMethod();
  }
}