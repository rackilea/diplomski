public static void main(String[] args) throws Exception {
    String input = "tag1:\n" 
            + " line1word1 lineoneanychar\n" 
            + " line2word1\n"
            + "tag2:\n" 
            + " line1word1 ....\n" 
            + " line2word1 .....\n";

    Pattern p = Pattern.compile("tag\\d+:$\\n((?:^\\s.*?$\\n)+)", Pattern.DOTALL|Pattern.MULTILINE);
    Matcher m = p.matcher(input);
    while(m.find()){
        System.out.println(m.group(1));
    }
}