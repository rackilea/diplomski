public class YourClass extends YourAbstractClass {

    private static int id = 0;

    @Override
    public int getId() {
        return ++id;
    }

}