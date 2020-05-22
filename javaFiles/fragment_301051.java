public static String cleanDescription(String desc){

        String trim = desc.replaceAll("<.*?>", ""); //removes html elements
        //there's a phantom question mark that sometimes gets added to the the front and end of the string
        if(!Character.isLetter(trim.charAt(0))) trim = trim.substring(1, trim.length());

        Integer charCount = 0;
        for(int j = 1; j <= 3; j++){
            if(!Character.isLetter(trim.charAt(trim.length() - j)) &&
                    !Character.isDigit(trim.charAt(trim.length() - j))) charCount++;
        }
        if(charCount >= 2) trim = trim.substring(0, trim.length() - (charCount - 1));


        Pattern pt = Pattern.compile("[^a-zA-Z0-9()\\.\\,]");
        Matcher match= pt.matcher(trim);
        while(match.find())
        {
            String s = match.group();
            trim = trim.replaceAll("\\" + s, " ");
        }

        return trim.trim();
    }