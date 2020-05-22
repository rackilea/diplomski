public static void main(String[] args) {
    final String s = "10067829311288";
    final List<Integer> split = new LinkedList<>();
    final Pattern pattern = Pattern.compile("1?\\d{2}");
    final Matcher matcher = pattern.matcher(s);
    while (matcher.find()) {
        split.add(Integer.parseInt(matcher.group()));
    }
    System.out.println(split);
}