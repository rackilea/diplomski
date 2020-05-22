List<Cat> myList = new ArrayList();    
myList.add(new Cat());
myList.add(new Integer(1));  // compile time error
myList.add(new Dog()); // compile time error

Cat whatIsThis = myList.get(1); // I *know* this must be a Cat