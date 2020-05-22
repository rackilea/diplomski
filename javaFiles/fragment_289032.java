abstract class MyClassInterface extends MyClass implements MyInterface {}

List<MyClassInterface> myList;


<T extends MyClassInterface> void foo(T bar)