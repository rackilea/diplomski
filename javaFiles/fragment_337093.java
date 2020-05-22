public static boolean testString(String testString)
{
    String allowedCharacters = "hello";

    for(int i = 0; i < testString.length(); i++) {
        int position = allowedCharacters.indexOf(testString.charAt(i));

        if(position == -1) {
            System.out.println(testString + " - fail");
            return false;
        } else {
            allowedCharacters = allowedCharacters.substring(0, position)
                              + allowedCharacters.substring(position + 1);
        }
    }


    System.out.println(testString + " - success");
    return true;
}