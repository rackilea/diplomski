SomeType inst1 = new SomeType("SAME VALUE");
SomeType inst2 = new SomeType("SAME VALUE");

bool areEqual = inst1.equals(inst2);  // calls the overriden equals method on SomeType
                                      //   which would return TRUE 

// but if you use object:

Object obj1 = new Object();
Object obj2 = new Object();

bool areEqual = obj1.equals(obj2);    // will call equals on Object;
                                      //   and always return false;