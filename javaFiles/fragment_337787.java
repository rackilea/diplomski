package test;

public class J extends E {
  public J() {}
}

$ javac -cp /jvm/scala-library.jar:. J.java
J.java:3: test.J is not abstract and does not override
          abstract method z() in test.B