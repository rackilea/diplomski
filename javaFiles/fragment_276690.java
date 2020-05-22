// Case 1
Object o1 = instance;
instance = new Object();
Object o2 = instance;

// Case 2
Object o1 = instance;
if (o1 == null)
  instance = new Object();
Object o2 = instance;