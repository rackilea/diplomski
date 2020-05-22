public class Test {


 public static void main(String[] args) {
        List<String> arrList = new ArrayList<String>();
        arrList.add("FOO");
        Test test = new Test(); // now what?
        String testStr = test.returnWhat(0); // no warning...
        JPanel p = test.returnWhat(0); // goes through without warning, real nice...
        test.returnWhat(0); // returns Object

        Test test2 = new Test(arrList);
        test2.addElement(new Object()); // boom, inserted object into list of string.
        String nono = test2.returnWhat(1); // the universe goes down. assign an object to string without warning. even
                                           // though one COULD think the class is generic.
    }

    // private List<T> myList = new ArrayList<T>(); compiler error, T is unknown
    private List myList = new ArrayList();

    public Test() {
        myList.add(new Object());
    }

    public <T> Test(List<T> ttype) {
        myList = ttype;
    }

    public <T> T returnWhat(int index) {
        return (T) myList.get(index);
    }

    public <T> void addElement(T el) {
        myList.add(el);
    }
}