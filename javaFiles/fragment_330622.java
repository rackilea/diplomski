public class Main {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        list.add(30);
        list.add(50);
        list.add(5);
        list.add(60);
        list.add(90);
        list.add(5);
        list.add(80);
        System.out.println(list);
        combine(list, 2, 3);
        System.out.println(list);
    }
    public static void combine(List<Integer> list, int indexA, int indexB) {
        Integer a = list.get(indexA);
        Integer b = list.get(indexB);
        list.remove(indexB); // [30, 50, 5, 90, 5, 80]
        list.add(indexA, a + b); // [30, 50, 65, 5, 90, 5, 80]
        list.remove(indexB); // [30, 50, 65, 90, 5, 80]
    }
}