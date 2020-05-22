public class Test implements Comparator<String> {

    @Override
    public int compare(String s, String b) {
        return s.compareTo(b);
    }

    public static void main(String[] args) {   
        Test t = new Test();
        System.out.println(t.compare("baba","baba"));
    }

}