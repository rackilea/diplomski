public static void main(String [] args) {

    String input = "[(1,2) (3,4) (5,6)]";

    Pattern pattern = Pattern.compile("(\\d+),(\\d+)");
    Matcher matcher = pattern.matcher(input);

    List<Node> nodes = new ArrayList<Node>();
    Node node = null;
    while (matcher.find()) {
        node = new Node();
        node.setX(Integer.parseInt(matcher.group(1)));
        node.setY(Integer.parseInt(matcher.group(2)));
        nodes.add(node);
        System.out.printf("x=%d, y=%d\n", node.getX(), node.getY());
    }
}