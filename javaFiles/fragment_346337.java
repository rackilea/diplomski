// Get the Class of the type you're grabbing methods from
Object target = new SomeObject();
Class theClass = target.getClass();
// Or, use the class literal:
Class theClass = SomeObject.class;

// Get the methods you want
// You need to know the method name and its parameter types.
Method aMethod = theClass.getMethod("move", Integer.class);

List<Method> myMethods = new LinkedList<Method>();
myMethods.add(aMethod);

// Later, you need an object on which to invoke a method.
Method currentMethod = myMethods.get(0);
currentMethod.invoke(target, 4);