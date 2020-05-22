private int parseString(String input, String parent, 
                        Map<String, ArrayList<String>> levels) {

     StringBuilder currentString = new StringBuilder();
     int index = 0;
     while(index < input.length()) {
         char c = input.charAt(index);

         if(c == ' ') { // ignore spaces
             index++;
             continue;
         }

         if(c == ';') { // end of menu entry, add to the list
             if(!currentString.toString().isEmpty()) {
                 levels.put(currentString.toString(), new ArrayList<String>());             
                 levels.get(level).add(currentString.toString());
             }
             currentString.delete(0, currentString.length());
             index++;
             continue;
         }

         if(c == ']') { // end of sublist, return
             return index + 1;
         }

         if(c == '[') { // start of sublist, recursive call
             int temp = parseString(input.substring(index + 1), 
                                    levels.get(parent).get(levels.get(parent).size() - 1), levels);
             index += temp;
             index++;
             continue;
         }

         currentString.append(c);
         index++;             
     }
     return 0;
}