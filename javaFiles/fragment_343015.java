public static String editNoHP (String noHPinput){
    String result;
    try {
        noHPinput = noHPinput.trim();
        String noHP = noHPinput;
        noHP = noHP.replaceAll("[\\s\\-\\.\\^:,]","");
        noHP = noHP.replaceAll("[^A-Za-z0-9]","");
        char isinya = noHP.charAt(0);

        if(isinya == '0')
            result = "62"+noHP.substring(1);
        else if(isinya == '+' )
            result = noHP.substring(1);
        else
            result = noHP;

    }
    catch (Exception e){
        return "";
    }

    return result;
}