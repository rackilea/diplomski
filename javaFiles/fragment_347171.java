public static String toUpCase(String phrase) {
        //split the phrase with space
        String[] words = phrase.split(" ");

        //Use StringBuilder to append the strings
        StringBuilder output = new StringBuilder();

        //loop the words array
        for(int i=0; i < words.length; i++) {
            String temp = words[i];
            output.append(Character.
               toUpperCase(temp.charAt(0))).//convert the first char to uppercase
                append(temp.substring(1)).//get the string from index 1
                append(" ");//append space for each word
        }
        return output.toString();//convert stringbuilder to string 
    }