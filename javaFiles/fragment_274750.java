String text = "['Stack1', 'Stack2']";
StringTokenizer tkn = new StringTokenizer(text.substring(1, text.length() - 1), ", ");
while (tkn.hasMoreTokens()) {
    String v = tkn.nextToken();
    System.out.println(v.substring(1, v.length() - 1)); // Stack1 Stack2
}