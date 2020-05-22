final String input = "6232663064613430656332633131653030303030323432643530636631666266";
System.out.println("input: " + input);
final StringBuilder result = new StringBuilder();
for (int i = 0; i < input.length(); i += 2) {
    final String code = input.substring(i, i + 2);
    final int code2 = Integer.parseInt(code, 16);
    result.append((char)code2);

}
System.out.println("result: " + result);