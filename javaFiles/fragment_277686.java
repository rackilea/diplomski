public static boolean isAlphaOpp (String word)
    {
        //if word has odd number of characters, it cannot be an alpha opp
        if (word.length() % 2 != 0)
        {
            return false;
        }
        //if string makes it to 0, then word must be an alpha opp
        if (word.length() == 0)
        {
            return true;
        }

        /*if (word.charAt(0) + word.charAt(word.length()-1) == 155)
            {
                System.out.println(word.substring(1, word.length()-1));
                return isAlphaOpp(word.substring(1, word.length()-1));
            }
        */
        //Should go thru each letter and compare the values with char(0). If char(0) +     //char(i) == 155 (a match) then it should remove them and call the method again.
        int length = word.length()-1;
        int start = 0;
        String newStr = null;
        while(start < length) {

            if(word.charAt(start) + word.charAt(length) == 219) {
                StringBuilder sb = new StringBuilder(word);
                sb.deleteCharAt(length);
                sb.deleteCharAt(start);
                newStr = sb.toString();
                System.out.println(newStr);
                start++;
                length--;
                break;
            } else {
                start++;
            }
        }
        if(newStr != null) {
            return isAlphaOpp(newStr);
        }
        return false;
    }