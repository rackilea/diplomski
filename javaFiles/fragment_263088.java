public class Test {
    public static void main(String[] args) {
        MyType<Integer> test = new MyType<Integer>("hello", 1, "world");
        // attempting to use the member variable as an Integer
        System.out.println(test.getMember().doubleValue());
        }

    public static class MyType<T> {
        private T member;

        public MyType(Object o, Object o2, Object o3) {
            T t = (T) o;
            member = (T) o2;
            System.out.println(t.getClass());
            System.out.println(member.getClass());
            member = (T) o3;
            System.out.println(member.getClass());
        }

        public T getMember() {
            return member;
        }
    }
}