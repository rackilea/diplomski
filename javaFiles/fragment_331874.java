public static void main(String[] args) {
    System.out.println(Pattern.compile("([a-zA-Z]+)[^a-zA-Z@]*(@.*)?")
            .matcher("user.sure_name123@mail.co").results()
            .map(result -> result.group(1))
            .collect(Collectors.joining(" ")));
}