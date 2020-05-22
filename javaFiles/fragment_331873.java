public static void main(String[] args) {
    Pattern p = Pattern.compile("([a-zA-Z]+)[^a-zA-Z@]*(@.*)?");
    String input="user.sure_name123@mail.co";
    System.out.println(MatcherStream.results(p, input)
            .map(result -> result.group(1))
            .collect(Collectors.joining(" ")));
    // MatcherStream implementation http://stackoverflow.com/a/42462014/7098259
}