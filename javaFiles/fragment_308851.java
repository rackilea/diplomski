Class myClass = Class.forName("com.citi.MyClass");

    Constructor cons= myClass.getConstructor(Double.TYPE, String.class);

    Object[] param = {1.0, "Hello"};
    Object instanceOfMyClass = cons.newInstance(1.0, "Hello");