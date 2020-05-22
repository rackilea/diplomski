public static void main(String[] args) {
    String command = "-u User -P Password mkdir \"temp dir\" rmdir \"host dir\"";
    List<Integer> positions = new LinkedList<>();
    int position = command.indexOf("\"", 0);

    while (position != -1) {
        positions.add(position);
        position = command.indexOf("\"", position + 1);
    }
    System.out.println(positions);

    Pattern pattern = Pattern.compile("\"");
    Matcher matcher = pattern.matcher(command);
    positions = new LinkedList<>();

    while (matcher.find()) {
        positions.add(matcher.start());
    }

    System.out.println(positions);
}