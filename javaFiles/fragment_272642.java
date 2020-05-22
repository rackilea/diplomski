private String convertToArabic(String value) {
        if(value.indexOf("&#")==-1)
            return value;

        String newString ="";
        value = value.replaceAll("&#","");
        String[] characters = value.split(";");
        for(int i=0; i<characters.length; i++){
            if(characters[i].startsWith(" "))
                newString +=" ";

            if(characters[i].trim().length()!=4)
                newString += characters[i].trim();
            else
                newString +=(char)Integer.valueOf(characters[i].trim()).intValue()+"";
        }

        return newString;
    }