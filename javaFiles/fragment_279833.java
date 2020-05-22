public class PrintASCIIChar {

    public static void main(String[] args) {
       String str = "7289";
       String c = Character.toString((char)Integer.parseInt(str.substring(0, 2)));

       System.out.println("Printing: " + c);
    }

}