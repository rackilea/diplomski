String input = /* param of your method */;

Map<Character, String> replacements = new HashMap<>();
// Fill map in, like replacements.put('a', "bf");
// Parsing the json every time could be time consuming.
// The best structure here is a HashMap.
// So I'd suggest that you first create it from the json and then use it whenever.

String output = "";

for (char c : input.toCharArray()) {
    if (map.containsKey(c)) {
        output += map.get(c);
    } else {
        output += c;
    }
}

return output; // the result is here