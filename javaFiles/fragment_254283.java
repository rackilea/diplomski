@Test
public void constructorAvailableTest() {

    try {
        Constructor<Product> contructor = Product.class.getConstructor(String.class, String.class, Integer.class, String.class, String.class, String.class,
            String.class,String.class, String.class,Boolean.class);
    } catch( NoSuchMethodException nsme ) {
       fail( "The specified " + Product.class.getName() + " constructor does not exist!");
    }

}