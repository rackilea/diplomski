String str = "123|00,124|01,125|00,126|01";

// Split on `|` or `,` and then take every alternate element.
String[] tokens = str.split("[|,]");

List<Integer> intList = new ArrayList<Integer>();    
for (int i = 0; i < tokens.length; i = i + 2) {
    intList.add(Integer.parseInt(tokens[i]));
}