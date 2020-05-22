MyObject obj1 = new MyObject("setSomeStringInMyObject"); // Constructor approach
// Yippy, I can just use my obj1, as the values are already populated
// But even after this I can change the value
obj1.setSomeString("IWantANewValue"); // Value changed using setter, if required.
..
MyObject obj2 = new MyObject();
obj2.setSomeString("setSomeStringNow"); // Setter approach
// values weren't populated - I had to do that. Sad :(