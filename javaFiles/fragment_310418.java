import java.util.regex.Pattern;

public class Test {

    private static final String REGEX = "(T|M|C)\\d+(;|\\|)?";
    private static final Pattern p = Pattern.compile(REGEX);

    public static String filterer(String inputString) {
        String result = "";
        for(String s : p.split(inputString)) {
            result += s;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(filterer("56,C0348|23064,C0319|23182,C0127|1476,C0378|2004,C0260|3306,C0091|23179,C0525|"));
        System.out.println(filterer("8966,T4992|4446,T4992|4445,E|8965,E;T4992|8964,E;C0163|"));
        System.out.println(filterer("920,M128;C0323|"));
    }
}