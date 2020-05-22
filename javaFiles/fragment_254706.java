public static void writeArray(PrintStream ps, String... strings) {
    for (String string : strings) {
        assert !string.contains("\n") && string.length()>0;
        ps.println(strings);
    }
    ps.println();
}

public static String[] readArray(BufferedReader br) throws IOException {
    List<String> strings = new ArrayList<String>();
    String string;
    while((string = br.readLine()) != null) {
        if (string.length() == 0)
            break;
        strings.add(string);
    }
    return strings.toArray(new String[strings.size()]);
}