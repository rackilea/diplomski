public class Main {

    public static void main(String[] args) {
        String str = "JAVA\uD834\uDD61\u2665";
        int len = str.length();
        for(int i = 0; i < len; ) {
            int cp = str.codePointAt(i);
            i += cp > 0xFFFF ? 2 : 1;

            if(cp == "\u2665".codePointAt(0)) {
                System.out.println("Heart!");
            }
            else if(cp == "\uD834\uDD61".codePointAt(0)){
                System.out.println("Music!");
            }
            else{
                System.out.println((char)cp);
            }
        }
    }

}