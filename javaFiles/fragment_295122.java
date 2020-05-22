public class Foo {

    public static class Animal {
        public void save(String filename)
        {
            // Write to file
        }
        public static <T extends Animal> T load(String filename, Class<T> cls) throws Exception
        {
            T result = cls.newInstance();
            // initialize result
            return result;
        }
    }

    public static class Swan extends Animal {
        public static Swan load(String filename) throws Exception
        {
            return load(filename, Swan.class);
        }
    }

    public static void main(String[] args) throws Exception
    {
        Swan s = new Swan();
        s.save("somefile");
        Swan s2 = Swan.load("somefile", Swan.class);
        // OR equivalently
        Swan s3 = Animal.load("somefile", Swan.class);
        // OR also equivalent
        Swan s4 = Swan.load("somefile");
    }
}