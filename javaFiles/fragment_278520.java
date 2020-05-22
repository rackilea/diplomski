public class ArrayListExample {
    private static final String TO_FIND = "cdt";

    public static void main(String[] args) {
        ArrayList<String> al = new ArrayList<String>();
        al.add("abc");
        al.add("dde");
        //4 times
        al.add(TO_FIND);
        al.add(TO_FIND);
        al.add(TO_FIND);
        al.add(TO_FIND);

        ArrayList<String> al1 = (ArrayList<String>) al.clone();
        int count = 0;
        while (al1.contains(TO_FIND)) {
            al1.remove(TO_FIND);
            count++;
        }
        System.out.println(count);
    }
}