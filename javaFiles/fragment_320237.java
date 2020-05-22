public interface MyInterface<T> {
    List<T> query();  
}

public class MyInteger implements MyInterface<Integer> {
    // ...
}

// ...
MyInteger foo = new MyInteger();

// ...
List<Integer> list = foo.query();

// ...
Integer i = list.get(index);