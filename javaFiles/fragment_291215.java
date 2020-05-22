// the Java compiler remembers that there is a variable called 's' and that
// it has the type 'SuperClass'. Note that the compiler does not check the
// actual type of the instance. It just checks to see if the assignment is
// is valid. Since the right side is of type 'SubClass' and the left side
// has the type 'SuperClass' which is a parent of 'SubClass' this assignment
// is valid for the compiler. But it ONLY remembers that 's' is of type
// 'SuperClass' since that is what you told it about 's'.
SuperClass s = new SubClass();

// Here the compiler sees 's' and looks up its type. The type of 's' is
// 'SuperClass' as remembered earlier. javac will no go and look up the
// definition of 'SuperClass' and finds out that 'SuperClass' does not
// have a method with the name 'subClass' so you get a compiler error.
s.subClass();