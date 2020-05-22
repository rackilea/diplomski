// 'this' refers to the DataObject being committed (assuming things happen in its callback)

ObjectContext parallelContext = ... // create a new context here like you normally would

// 3.1 API; 3.0.x has a similar method with a slightly different sig
MyClass clone = parallelContext.localObject(this);

// if you are ok with cached old value, ignore the 'invalidateObjects' call.
// If not, uncomment it to ensure the object gets refetched. 
// Also 3.1 API. Should be easy to adjust for 3.0

// parallelContext.invalidateObjects(clone);

Object oldValue = clone.getXyz();