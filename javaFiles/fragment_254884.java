MyClass myClass = new MyClass(); // init class (calls constructor)
System.out.println(myClass.getMyString()); // prints "Hello world!"
myClass.setMyString("Hola"); // changes value of myString
System.out.println(myClass.getMyString()); // prints "Hola"

System.out.println(myClass.myString); // Error: cannot directly access private variable of java class MyClass.