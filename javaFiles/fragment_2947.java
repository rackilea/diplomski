public class Person implements Comparable<Number> {
    @Override
    public int compareTo(Number o) {
        return 0;
    }
    public static <T extends Comparable<? super T>> int methodX(List<T> data) {
            return 0;
    }
    public static <T> int methodY(List<? extends Comparable<? super T>> data) {
            return 0;
    }
    public static void main(String[] args) {
        methodX(new ArrayList<Person>()); // stricter ==> compilation error
        methodY<Object>(new ArrayList<Person>());
    }
}