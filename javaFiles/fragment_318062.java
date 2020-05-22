public static String pleaseGetUpperCase(String name){
    String uppercaseCharacters = "";
    for (int i=0;i<name.length();i++){
        char ch = name.charAt(i);
        if (Character.isUpperCase(ch)){
            uppercaseCharacters += ch;
        }
    }   
    return uppercaseCharacters;
}