abstract class SuperClass {  }

class SubClass extends SuperClass {  }

// copy
SuperClass[] subClasses = new SubClass[10];
SuperClass[] subClassesCopy = Arrays.copyOf(subClasses, 10);