public static void main(String args[]) throws Exception {
    Map<String, String> map = new HashMap<>();
    put(map, "+91", "India");
    put(map, "+94", "Sri Lanka");
    put(map, "+881", "Bangladesh");
    put(map, "+971", "UAE");
    put(map, "+977", "Nepal");
    map = Collections.unmodifiableMap(map);

    String mobileNumber = "+91123456789";
    System.out.println(countryCode(map.keySet(), mobileNumber));
}

private static void put(Map<String, String> map, String key, String value) {
    if (countryCode(map.keySet(), key) != null) {
        throw new IllegalArgumentException("...");
    }
    map.put(key, value);
}

public static String countryCode(Set<String> countryCodes, String number) {
    if (number == null || number.length() < 3) {
        throw new IllegalArgumentException("...");
    }
    String code = number.substring(0, 3);
    if (!countryCodes.contains(code)) {
        if (number.length() > 3) {
            code = number.substring(0, 4);
            if (!countryCodes.contains(code)) {
                code = null;
            }
        } else {
            code = null;
        }
    }
    return code;
}