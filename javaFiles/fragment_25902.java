// The next line should raise a warning about raw types
// if compiled with Java 1.5 or newer
List rawList = new ArrayList();

// Since this is a raw List, it can hold any object.
// Let's stick a number in there.
rawList.add(new Integer(42));

// This is an unchecked conversion. Not always wrong, but always risky.
List<String> stringList = rawList;

// You'd think this would be an error. But it isn't!
Object value = stringList.get(0);