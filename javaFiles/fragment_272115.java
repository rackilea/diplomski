public class Children extends Father {

    @Override
    public void showName(String name) {
        super.showName(name);
        System.out.println("my name is: " + name);
    }
}