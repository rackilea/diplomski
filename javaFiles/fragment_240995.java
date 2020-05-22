public class Collate {

    public static void main(String[] args) {
        String a = new String("hello");
        String b = new String("there");          
        System.out.print(collate(a,b));
    }

    public static String collate(String a, String b) {
        String collate = new String();
        for(int i=0;i<a.length();i++){
            collate += a.charAt(i);
            collate += b.charAt(i);
        }

        return collate;
    }
}