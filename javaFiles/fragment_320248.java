DemoInterface<Type> demo = new DemoInterface<>() {
 <V> void demoMethod(Collection<V> someValues, SomeType<V, Type> moreValues) {
  Type type = new Type();
  foreach(V value: someValues) {
   Type subtype = moreValues.doSomething(value);
   type.concat(subtype);
  }
  System.out.printf("result: %s%n", type); 
 }
};

SomeType<ValueA, Type> someA = new SomeType<>();
SomeType<ValueB, Type> someB = new SomeType<>();
List<ValueA> listA = new Arraylist<>(); // add some elements
List<ValueB> listA = new Arraylist<>(); // add some elements

demo.demoMethod(listA, someA);    
demo.demoMethod(listB, someB);