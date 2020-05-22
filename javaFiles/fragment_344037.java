// declare a variable of type `Scanner`
Scanner keyboard; 

// call constructor of class `Scanner` and pass `Systen.in` as a parameter to create a new instance 
// and assign its reference to `keyboard`
keyboard = new Scanner(System.in);  

// declare a variable of type `String` and 
// assign to it the return value of `next()` method called on `keyboard` object
String userInput = keyboard.next();