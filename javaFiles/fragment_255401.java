class NumberTest {
    final static Pattern pattern = Pattern.compile("R(\\d+)");

    public static void main(String[] args) {
        System.out.println(new NumberTest().getNumber("R0"));
    }

    private int getNumber(String commandChunk) {
        Matcher m = pattern.matcher(commandChunk);
        if (m.matches()) {
            return Integer.parseInt(m.group(1));
        } else {
            return -1;
        }
    }
}