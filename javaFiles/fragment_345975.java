String javaClass = "code of new java Class2 that extends existing Class1";
SimpleCompiler sc = new SimpleCompiler();
sc.cook(javaClass);
Class<?> executeClass = sc.getClassLoader().loadClass("Class2");

Class1 instance = (Class1) executeClass.getConstructor().newInstance();