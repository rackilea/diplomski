public class Main {
    public static void main(String[] args){
        String example = "//This is a comment and I need this \\n position\n" +
                "String notwanted =\"//I do not need this end of line position\";";
        Pattern regex = Pattern.compile("(?<!\")//[^\\n]+(\\n)");
        Matcher matcher = regex.matcher(example);
        while (matcher.find()) {
                System.out.println(matcher.start(1));
        }
    }
}