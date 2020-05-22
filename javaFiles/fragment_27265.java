public class Test002 {

    // private static String s = " 10 sin 5 ( x - 4 ) - 14 ";

    // private static String s = " 10 sin 2x ";

    private static String s = " -4  sin -7 (x+6) - 2 ";

    private static int i = 0;

    public static void main(String[] args){
        String str = s.replaceAll(" ", "");
        s = str;
        parseExpr();
    }

    private static void parseExpr(){
        parseA();
        parseSin();
        parseSinArgument();
        parseD();
    }

    private static void parseSinArgument(){
        parseB();
        if (s.charAt(i) == '('){
            parseOpenBracket();
            parseX();
            parseC();
            parseCloseBracket();
        }else{
            parseX();
        }
    }

    private static void parseA(){
        int j = i;
        while (s.charAt(i) != 's') i++;
        System.out.println("A=[" + getToken(j, i) + "]");
        // stay at the 's' now!
    }

    private static void parseSin(){
        int j = i;
        while (s.charAt(i) != 'n') i++;
        i++;
        // move past the 'n' now!
    }

    private static void parseB(){
        int j = i;
        while ( s.charAt(i) == '-' || Character.isDigit( s.charAt(i) )) i++;
        System.out.println("B=[" + getToken(j, i) + "]");
    }

    private static void parseOpenBracket(){
        int j = i;
        i++;
        System.out.println("OPEN_BRACKET=[" + getToken(j, i) + "]");
    }

    private static void parseX(){
        int j = i;
        while (s.charAt(i) != 'x') i++;
        i++;
        System.out.println("X=[" + getToken(j, i) + "]");
    }

    private static void parseC(){
        int j = i;
        while (s.charAt(i) != ')') i++;
        System.out.println("C=[" + getToken(j, i) + "]");
    }

    private static void parseCloseBracket(){
        int j = i;
        i++;
        System.out.println("CLOSE_BRACKET=[" + getToken(j, i) + "]");
    }

    private static void parseD(){
        int j = i;
        while (i<s.length()) i++;
        System.out.println("D=[" + getToken(j, i) + "]");
    }

    private static String getToken(int i1, int i2){
        String str = s.substring(i1, i2);
        str = str.replaceAll(" ", "");
        return str.trim();
    }

}