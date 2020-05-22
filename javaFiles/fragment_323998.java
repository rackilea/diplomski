stringStack.push( “Jane” ); 
// Jane
stringStack.push( “Jess” ); 
// Jess Jane
stringStack.push( “Jill” ); 
// Jill Jess Jane
stringStack.push( stringStack.pop()); 
// Jill Jess Jane
stringStack.push( stringStack.peek()); 
// Jill Jill Jess Jane
stringStack.push( “Jim” ); 
// Jim Jill Jill Jess Jane
String name = stringStack.pop(); 
// Jill Jill Jess Jane
stringStack.push( stringStack.peek());
// Jill Jill Jill Jess Jane