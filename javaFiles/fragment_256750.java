import java.util.regex.*;
class rtest { 
    static String regex = "(\\w*)fell\\s[to|off|from\\sthe]\\s*(\\w*)";
    static Pattern pattern = Pattern.compile(regex);

    public static void main(String[] args) {
        process("Bob fell off the bike");
        process("Matt fell to the bottom");
        process("I think Terry fell from the beat of a different drum");
    }
    static void process(String text) {
        System.out.println(text);
        String[] tokens = text.split(regex);
        for(String t : tokens) System.out.println(t);
        System.out.println(" ");
    }
}