Dog d1 = new Dog("clover");
// what "put" is effectively doing: there is *no* Copy/Clone
Dog inMap = d1;
t(inMap == d1);                 // true: same object, reference equality!
d1.name = "arthur";
t(inMap.name.equals("arthur")); // true: same object! "name" member was *mutated*
t(d1.equals(inMap));            // true: same object!