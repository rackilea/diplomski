public static void main(String[] args) {
    final Pattern pattern = Pattern.compile("(?m)^(\\d\\d:\\d\\d:\\d\\d)");
    final Matcher matcher = pattern.matcher("00:02:10-XYZ:Count=10\n00:04:50-LMK:Count=3");
    while(matcher.find())
    {
        System.out.printf("[%s]\n", matcher.group(1));
    }        
}