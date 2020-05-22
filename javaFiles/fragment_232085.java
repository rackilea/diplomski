Map<Character, String> translit = new HashMap<>();
 static {
     translit.put('а', "a");
     translit.put('б', "b");
     translit.put('в', "v");
     // ...
     translit.put('ж', "zh");
     // and so on
 }


 public String transliterate(String input) {
     char[] c = input.toCharArray();
     StringBuilder output = new StringBuilder();
     for (char ch : c) {
         output.append(translit.contains(ch) ? translit.get(ch) : String.valueOf(ch));
     }
     return output.toString();
 }