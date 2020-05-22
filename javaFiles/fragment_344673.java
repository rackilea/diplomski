// Creates an Object of Type Wg and invokes the toString Method
// x = static i.e. shared between all classes (here: x = 0)
// x++;
// s = String.valueOf(y) = "0"
String s = new Wg().toString();
// Creates an Object of Type Wg and invokes the toString Method
// x = static i.e. shared between all classes (here: x = 1)
// x++;
// s = "0"+String.valueOf(y) = "01"
s += new Wg().toString();
// Creates an Object of Type Wg and invokes the toString Method
// x = static i.e. shared between all classes (here: x = 2)
// x++;
// s = "01"+String.valueOf(y) = "012"
s += new Wg().toString();
System.out.println(s);