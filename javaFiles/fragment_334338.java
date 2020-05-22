static Pattern pattern = Pattern.compile("(\\d+) \\: \\{\\s+([^}]+)\\s+\\}");// : \\{(?:\\s+(\\d+),?)\\s\\}$");

public static void main(String[] args) throws Exception {

    InputStream resourceAsStream = FileRead.class.getResourceAsStream("/numbers.txt");
    String content = IOUtils.toString(resourceAsStream);
    System.out.println("collec: " + collect(content));
}

public static Map<Integer, Integer[]> collect(String content) {
    Map<Integer, Integer[]> map = new HashMap<Integer, Integer[]>();
    Matcher matcher = pattern.matcher(content);
//        System.out.println("content: " + content);
    while (matcher.find()) {
        String strKey = matcher.group(1);
        Integer intKey = Integer.parseInt(strKey);
        String intGroupStr = matcher.group(2);
        String[] intValueStr = intGroupStr.split(", ");
        Integer[] intArray = new Integer[intValueStr.length];
        for (int i = 0; i < intValueStr.length; i++) {;
            intArray[i] = Integer.parseInt(intValueStr[i]);
//                System.out.println("intArray[" + i + "] " + intArray[i]);
        }
        map.put(intKey, intArray);
    }
    return map;
}