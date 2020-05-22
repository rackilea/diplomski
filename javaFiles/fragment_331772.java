public class Main {
    public static void main(String[] args){
        String example =
                "//This is a comment and I need this \\n position\n" +
                "String notwanted =\"//I do not need this end of line position\";\n" +
                "String a = aaa; //comment here";
        Pattern regex = Pattern.compile("(?m)(?<=(^|;\\s{0,1000})//[^\n]{0,1000})(\n|$)");
        Matcher matcher = regex.matcher(example);
        while(matcher.find()){
            System.out.println(matcher.start());
        }
        System.out.println(example.replaceAll("(?<=(^|;\\s{0,1000})//[^\n]{0,1000})(\n|$)", " (X)\n"));
    }
}