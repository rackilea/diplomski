public class TestSomething {
    public int elem1 = 1;
    public int elem2 = 2;
    public int elem3 = 3;
    public int elem4 = 4;
    public static void main(String[] str) throws NoSuchFieldException,IllegalAccessException {
        TestSomething test = new TestSomething();
        int num = 3;
        Field field = test.getClass().getField("elem" + num);
        System.out.println(field.get(test));
    }
}