interface Interface {
}

class Foo implements Interface {
    Foo(int magicInt) { magicInt = magicInt + 1; /* do some fancy calculations */ }
}

class Bar implements Interface {
    Bar(int magicInt) { magicInt = magicInt + 2; /* do some fancy calculations */ }
}

class Factory<T extends Interface> {
    int magicInt = 0; 

    public T createNewObject(Class<T> typeToMake) {
        try {
            T t = createNewObjectWithReflection(typeToMake);
            return t;
        } catch (Exception e) {
            throw new RuntimeException("Construction failed!", e);
        }
    }

    private T createNewObjectWithReflection(Class<T> typeToMake) throws Exception {
        // find the constructor of type to make with a single int argument
        Constructor<T> magicIntConstructor = typeToMake.getDeclaredConstructor(Integer.TYPE);
        // call the constructor with the value of magicInt
        T t = magicIntConstructor.newInstance(magicInt);
        return t;
    }
}

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
    public static void main (String[] args) throws java.lang.Exception
    {
        Factory<Foo> fooFactory = new Factory<Foo>();
        Foo foo = fooFactory.createNewObject(Foo.class);
        System.out.println(foo);

        Factory<Bar> barFactory = new Factory<Bar>();
        Bar bar = barFactory.createNewObject(Bar.class);
        System.out.println(bar);
    }
}