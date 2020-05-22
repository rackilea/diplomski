public static final String START = "start(";
public static final String END = ")end";

// ...

Scanner scanner = new Scanner(
        "key1=1\n" +
        "key2=start(a\n" +
        "b\n" +
        "c=\n" +
        "d)end\n" +
        "key3=d=e=f\n" +
        "somekey=start(123)end\n" +
        "morekey=start(1\n" +
        "2)end\n" +
        "key=jj");

Map<String, String> map = new HashMap<>();
while (scanner.hasNext()) {
    String line = scanner.nextLine();
    int eq = line.indexOf('=');
    String key = line.substring(0, eq);
    String value = line.substring(eq + 1);
    if (value.startsWith(START)) {
        StringBuilder sb = new StringBuilder(value.substring(START.length()));
        while (!value.endsWith(END)) {
            value = scanner.nextLine();
            sb.append('\n').append(value);
        }
        value = sb.substring(0, sb.length() - END.length());
    }
    map.put(key, value);
}

for (Map.Entry<String, String> entry : map.entrySet()) {
    System.out.printf("%s -> %s\n", entry.getKey(), entry.getValue());
}