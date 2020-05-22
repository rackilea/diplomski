Class myClass = Class.forName("MyClass");

Class[] types = {Double.TYPE, this.getClass()};
Constructor constructor = myClass.getConstructor(types);

Object[] parameters = {new Double(0), this};
Object instanceOfMyClass = constructor.newInstance(parameters);