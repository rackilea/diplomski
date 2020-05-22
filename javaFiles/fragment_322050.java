public static String translate(String fromLang, String toLang, String text) throws Exception {

    // ... Most method code here ...

    String output;
    StringBuilder sb = new StringBuilder();
    while ((output = br.readLine()) != null) {
        sb.append(output).append(System.lineSeparator());
        System.out.println(output);  // Optional - For testing
    }
    conn.disconnect();

    return sb.toString();
}