public class stackoverflow {
    public static void main(String[] args) throws IllegalArgumentException, 
            IllegalAccessException, NoSuchFieldException {
        stackoverflow2 sf2 = new stackoverflow2();
        Field f = sf2.getClass().getDeclaredField("testPrivate");
        f.setAccessible(true);
        int testPrivateReflection = (int)f.get(sf2);
        System.out.println(testPrivateReflection);
        f.set(sf2, 15);
        sf2.print();
    }
}