public class Test {
    public static void main(String[] args) {
        List<String> arrList = new ArrayList<String>();
        arrList.add("FOO");
        Test test = new Test(arrList);
        String testStr = test.returnWhat();
        System.out.println("testStr");
    }

    private final List myList; //warning

    public <T> Test(List<T> ttype) {
        myList = ttype;
    }

    public <T> T returnWhat() {
        return (T) myList.get(0); //warning
    }
}