MyConstructor (String someThingNecessary)
 {
    initializeMyMap(someThingNecessary);

    // other initialization stuff unrelated to myMap
 }


 // helper doesn't work since it can't modify a final member
 private void initializeMyMap(String someThingNecessary)
 {

     myMap.clear();
    myMap.put("blah","blahblah");
    // etc...
  }