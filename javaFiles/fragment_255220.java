public class Foo {
    public static void main(String[] args) {

        ArrayList<Integer> array = new ArrayList<Integer>();
        HashMap<String, ArrayList<Integer>> foo = new HashMap<String, ArrayList<Integer>>();

        for (int i = 0; i < 20; i++)
            array.add(i);

        ArrayList<Integer> newList = new ArrayList<Integer>(array);

        foo.put("1", newList);
        array.clear();

        System.out.println(foo.get("1").size());
    }

}