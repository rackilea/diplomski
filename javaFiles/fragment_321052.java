public static void main(String[] args){

    String test = "\\d";
    String word = "a1ap1k7";

    Pattern p = Pattern.compile(test);
    Matcher b = p.matcher(word);

    while (b.find())
    {
        int start = b.start();
        String text = b.group();
        int stop = b.end();
        System.out.println(start + text + stop);
    }
}