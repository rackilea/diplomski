String str = "a_1 & b_2 | (!c_3)";  // initial string

StringCharacterIterator sci = new StringCharacterIterator(str);  // we use a string iterator for iterating over each character

List<String> strings = new ArrayList<String>();  // this will be our array of strings in the end

StringBuilder sb = new StringBuilder();  // a string builder for efficiency

for(char c = sci.first(); c != sci.DONE; c = sci.next()) {
    if( c == ' ' ) {
        continue;  // we ignore empty spaces
    }


    else if( 
        c == '&' ||
        c == '(' ||
        c == ')' ||
        c == '|' ||
        c == '!') 
    {
        // if we stumble upon one of 'tokens', we first add any previous strings that are variables to our string array, then add the token and finally clean our StringBuilder

        if(sb.length() != 0) strings.add(sb.toString());
        strings.add(String.valueOf(c));
        sb = new StringBuilder();
    }
    else {
        sb.append(c);  // we have a character that's part of a variable
    }

}



String[] finalArray = strings.toArray(new String[0]);  // we turn our list to an array

for (String string : finalArray) {
    System.out.println(string);  // prints out everything in our array
}