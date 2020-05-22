public static void main(String[] args) throws Exception {
    System.out.println(createMask(5, "val"));
    System.out.println(createMask(3, "xx"));
}

private static List<String> createMask(int length, String value) {
    List<String> list = new ArrayList<String>();
    String base = new String(new char[length]).replace("\0", "_");
    for (int offset = 0; offset <= length - value.length(); offset++) {
        StringBuilder buffer = new StringBuilder(base);
        buffer.replace(offset, offset + value.length(), value);
        list.add(buffer.toString());
    }
    return list;
}