Map<String, Integer> myMapOfThings = new HashMap<>();

String nameOfThing = /* ... get a string from the user somehow here ... */;
myMapOfThings.put(nameOfThing, 2);

System.out.println(myMapOfThings.get(nameOfThing)); // prints 2