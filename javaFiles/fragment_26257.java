public class UnicodeExample {

    public static void main(String[] args) {

        String escaped = new String("\u00f1");
        String unescaped = new String("ñ");
        System.out.println(escaped);        
        System.out.println(unescaped);

        if(escaped.equals(unescaped)){
            System.out.println("The strings are the same!");
        }
        else {
            System.out.println("The strings are different!");
        }

    }

}