package de.scrum_master.app;

import static de.scrum_master.app.FieldHelper.*;

public class B {
  @IgnoreFields(fieldNames = { "optionalText", "optionalNumber" })
  A noOptionalsA = new A();

  @IgnoreFields(fieldNames = { "text", "number", "date" })
  A onlyOptionalsA = new A();

  public static void main(String[] args) {
    B b = new B();
    b.noOptionalsA.doSomething(extractIgnoredFieldsList(b.getClass(), "noOptionalsA"));
    System.out.println("----------------------------------------");
    b.onlyOptionalsA.doSomething(extractIgnoredFieldsList(b.getClass(), "onlyOptionalsA"));
  }
}