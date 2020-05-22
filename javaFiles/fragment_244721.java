public class Main {
    // the instance field
    String simple = "foo";
    // some static main method
    public static void main(String[] args) throws Exception {
        // initializing the class as we're accessing an instance method
        new Main().reflect();
    }

    public void reflect() {
        Class<?> c = this.getClass();
        try {
            // using getDeclaredField for package-protected / private fields
            Field field = c.getDeclaredField("simple");
            // printing out field's value for this instance
            System.out.println(field.get(this));
        }
        // TODO handle better
        catch (IllegalAccessException iae) {
            iae.printStackTrace();
        }
        catch (NoSuchFieldException n) {
            n.printStackTrace();
        }
    }
}