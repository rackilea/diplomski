static Map<String, String> map = new HashMap<>();

static {
    for (int i = 1; i < 26; ++i)
        map.put(Integer.toString(i), Character.toString((char)('A' + i - 1)));
}

static void decode(String decoded, String encoded, List<String> result) {
    int len = encoded.length();
    if (len == 0)
        result.add(decoded);
    else
        for (int i = 1, max = Math.min(2, len); i <= max; ++i) {
            String e = map.get(encoded.substring(0, i));
            if (e != null)
                decode(decoded + e, encoded.substring(i), result);
        }
}

public static List<String> decode(String encoded) {
    List<String> result = new ArrayList<>();
    decode("", encoded, result);
    return result;
}

@Test
public void testDecode() {
    System.out.println(decode("121"));
    System.out.println(decode("1201"));
}