public class Test{
    public static void main(String[] args){
        String test = "var bold, det, bold=6, sum, k\n" +
                "var foo=6, abc, foo, xyz, k";
        Matcher matcher = Pattern.compile("(?<=var.{0,999})(?<!=)(?!var)\\b(?<var>\\w+)\\b(?<!var.{1,999}(?=\\k<var>).{1,999}(?=\\k<var>).{1,999})").matcher(test);
        while(matcher.find()){
            System.out.println(matcher.group("var") + "," + matcher.start("var") + "," + matcher.end("var"));

        }

    }
}