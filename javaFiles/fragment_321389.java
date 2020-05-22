Cage<?> cage1 = new Cage<Integer>();
Cage<?> cage2 = new Cage<String>();
Cage<?> cage3 = new Cage<T>();

someMethod(cage1);
someMethod(cage2);
someMethod(cage3);

public void someMethod(Cage<?> cage) {
  cage.add(1);                // Will not compile
  cage.add("A String");       // Will not compile
  cage.add(someValueOfTypeT); // Will not compile
}