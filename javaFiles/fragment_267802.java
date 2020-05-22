private static final Map<String, Character> lookupHex = new HashMap<String, Character>();

static {
    for(int i = 0; i < 256; i++) {
        String key = Integer.toHexString(i);
        Character value = (char)(Integer.parseInt(key, 16));
        lookupHex.put(key, value);
    }
}

public static String hexToString(String hex) {
    StringBuilder sb = new StringBuilder();
    for (int count = 0; count < hex.length() - 1; count += 2) {
        String output = hex.substring(count, (count + 2));
        sb.append((char)lookupHex.get(output));
    }
    return sb.toString();
}