E:\workspace>javap com\example\withinterface\SomeClass
Warning: Binary file com\example\withinterface\SomeClass contains com.example.wi
thinterface.SomeClass
Compiled from "SomeClass.java"
public class com.example.withinterface.SomeClass {
  public com.example.withinterface.SomeClass();
}

E:\workspace>javap com\example\withinterface\SomeClass$SomeInterface
Warning: Binary file com\example\withinterface\SomeClass$SomeInterface contains
com.example.withinterface.SomeClass$SomeInterface
Compiled from "SomeClass.java"
public interface com.example.withinterface.SomeClass$SomeInterface {
  public abstract void doSomething();
}