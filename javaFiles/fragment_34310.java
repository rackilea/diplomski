public class Test {
    public static void main(String[] args) {
        test('h', 'e', 'l', 'l', 'o');
        test('m', 'a', 'i', 'n');
    }
    static void test(char... arg) {
        String s1 = new String(arg), s2 = s1.intern();
        System.out.println('"'+s1+'"'
            +(s1!=s2? " existed": " did not exist")+" in the pool before");
        System.out.println("is the same as \"hello\": "+(s2=="hello"));
        System.out.println("is the same as \"main\": "+(s2=="main"));
        System.out.println();
    }
}