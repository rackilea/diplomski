public class CastArray {

    public static void main(String[] args) {
        CastArray test = new CastArray();
        test.TestObj(new int[]{1, 2, 4});
        test.TestObj(new char[]{'c', 'a', 'a'});
        test.TestObj(new String[]{"fdsa", "fdafds"});
    }

    public void TestObj(Object obj) {
        if (!(obj instanceof Object[])) {
            if (obj instanceof int[]) {
                for (int i : (int[]) obj) {
                    System.out.print(i + " ");
                }
                System.out.println("");
            }
            if (obj instanceof char[]) {
                for (char c : (char[]) obj) {
                    System.out.print(c + " ");
                }
                System.out.println("");
            }
            //and so on, for every primitive type.
        } else {
            System.out.println(Arrays.asList((Object[]) obj));
        }
    }
}