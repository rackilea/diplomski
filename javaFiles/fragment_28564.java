String input = "key1=value1&key2=value2&key3=value3&key4=value4&key5=value5";
StringTokenizer st = new StringTokenizer(input, "&");

Map<String, String> map = new HashMap<String, String>();

while ( st.hasMoreElements() ) {

    String actualElement = st.nextToken();
    StringTokenizer et = new StringTokenizer(actualElement, "=");

    if ( et.countTokens() != 2 ) {
        throw new RuntimeException("Unexpeced format");
    }

    String key = et.nextToken();
    String value = et.nextToken();

    map.put(key, value);
}

System.out.println(map);