public static void main(String[] args) throws Exception {
    String list = "52 98 55 86 42 25 87 566 56 843";
    List<String> tokenList = new ArrayList<>();

    StringTokenizer tokenizer = new StringTokenizer(list);
    while(tokenizer.hasMoreTokens()){
        tokenList.add(tokenizer.nextToken());
    }

    if(tokenList.contains("25") && tokenList.contains("55")){
        System.out.println("both");
    } else {
        System.out.println("no");
    }
}