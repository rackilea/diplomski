Class<?> outerClass = Class.forName("myOuterClassName");
Object outerInstance = outerClass.newInstance();

Class<?> innerClass = Class.forName("myInnerClassName");
Constructor<?> ctor = innerClass.getDeclaredConstructor(outerClass);

Object innerInstance = ctor.newInstance(outerInstance);