import java.util.regex.*;

public static void main(String[] args) {

        Pattern headPattern = Pattern.compile("^(\\d+).*");
        Pattern tailPattern = Pattern.compile("\\((?<p1>\\d),(?<p2>\\d+\\.\\d+),(?<p3>€\\d+)\\)");
        Matcher m1 = headPattern.matcher("80 : (1,53.38,€45) (2,88.62,€98) (3,78.48,€3) (4,72.30,€76) (5,30.18,€9)");
        Matcher m2 = tailPattern.matcher("80 : (1,53.38,€45) (2,88.62,€98) (3,78.48,€3) (4,72.30,€76) (5,30.18,€9)");

        m1.matches();
        System.out.println("p0 = " + m1.group(1));

        while(m2.find()) {
            System.out.println("token = " + m2.group());
            System.out.println("p1 = " + m2.group("p1"));
            System.out.println("p2 = " + m2.group("p2"));
            System.out.println("p3 = " + m2.group("p3"));
        }
}