public static boolean isConsonant(char inputChar){

    final String consonantsx = "bBcCdDfFgGhHjJkKlLmMnNpPqQrRsStTvVwWxXzZ"; 
    char consonants[] = consonantsx.toCharArray(); // String to charr

    for(int i=0; i < consonants.length;i++){
        if(inputChar == consonants[i]){ //note that in Strings u use the equals method instead of "=="
            return true;
        }
    }

    return false;
}