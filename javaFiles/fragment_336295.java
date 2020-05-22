Collection<YourData> newCollection = ... //initialize it
for (... : currentCollection) {
     if (...) {
         YourData yourData = new YourData();
         //fill yourData variable
         //...
         //add it into newCollection
         newCollection.add(yourData);
     }
}
//roughly, you will end doing this or similar
currentCollection = newCollection;