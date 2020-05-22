public static String space(String input, int spaces) {
    HashMap<Character, Integer> map = new HashMap<>();
    StringBuilder result = new StringBuilder();
    for( char symbol : input.toCharArray() ) {
        int position = result.length();
        int lastPosition = map.getOrDefault(symbol, position-spaces-1);
        int distance = position - lastPosition -1;
        for( int j = 0; j < Math.max( spaces - distance, 0) ; j++ ) {
            result.append('_');
        }
        result.append(symbol);
        map.put(symbol, result.length()-1);
    }
    return result.toString();
}