public class MyClass {

    public String field1, field2;
}


...
    GenericClass generic= new GenericClass(sql2o);
    Store<MyClass> store = new Store<>();
    generic.storeGenericClass(store, MyClass.class);
    MyClass retrieved = store.get();
    System.out.println("My Class fields are: "+retrieved.field1 + "-"+retrieved.field2);
...