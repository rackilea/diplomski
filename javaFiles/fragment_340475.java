String filename = "savedHashSet.dat";

// Create it
Set<String> someStrings = new HashSet<String>();
someStrings.add("hello");
someStrings.add("world");

// Serialize / save it
ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename));
oos.writeObject(someStrings);

...
...
...

// Deserialize / load it
ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename));
Set<String> aNewSet = (HashSet<String>) ois.readObject();