public class MainTest<A,B,T extends Object1<A,B>> {
    List<T> list;

    public MainTest(List<T> l) {
        this.list=l;
    }
    public int testCompare() {
        // fails to compile here
        return list.get(0).compareTo(list.get(1));
    }

    public static void main(String[]args) {
        List<Object1Impl> list = new ArrayList<Object1Impl>();
        list.add(new Object1Impl());
        list.add(new Object1Impl());

        MainTest<Integer, Integer, Object1Impl> test = new MainTest<Integer, Integer, Object1Impl>(list);
        System.out.println(test.testCompare());
    }
}