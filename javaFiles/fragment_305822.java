import bsh.Interpreter;

Interpreter i = new Interpreter();  // Construct an interpreter
YourObject yourObject = new YourObject();
i.set("myObject", yourObject ); 

// Source an external script file
i.source("somefile.bsh");