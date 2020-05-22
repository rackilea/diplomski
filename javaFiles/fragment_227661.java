public static String invert(String input) 
    {

        String temp = "";

        //Iterate thru all of the characters in the string, in order of first to last
        for(int i = 0; i < input.length(); i++)
        {
            if (input.charAt(i) == '0') {
                temp += "1";
            } else {
                temp += "0";
            }
        }
        return temp;
    }