Map<ExampleKey, Integer> actualMapping = new HashMap<>();
Map<ExampleKey, ExampleClass> objsUsed = new HashMap<>();
while(true) {
   // ...
   ExampleClass oldObject = new ExampleClass(1, 2);
   ExampleClass newObject = new ExampleClass(1, 5);

   // always update both maps together, to ensure valid state
   actualMapping.put(oldObject.getKey(), 10);
   objsUsed.put(oldObject.getKey(), oldObject);

   // ...

   ExampleClass objUsed = objsUsed.get(newObject.getKey());
   if(objUsed != null) {
        // objUsed == oldObject here
   }
}