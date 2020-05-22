class SomeClass {
  protected List<CustomObject> getSortedOrderItems() {
    List<CustomObject> internalList = new ArrayList<>();
    //some operations
    return internalList;
  }
}

@groovy.transform.TupleConstructor
class CustomObject { int a }

// test setup:
SomeClass.metaClass.getSortedOrderItems = {-> [ new CustomObject(1), new CustomObject(2) ] }

// test
assert [ 1, 2 ] == new SomeClass().sortedOrderItems*.a