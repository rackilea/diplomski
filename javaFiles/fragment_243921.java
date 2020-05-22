public class Test {

    public static void main(String a[]){
    String result =mask("{\"id\":\"jack.sparrow@pirate.com\"}"); 

    System.out.println(result);

    }
    final static char ASTERICK = '*';
    final static char DOT = '.';
    final static char QUOTATION_MARK = '"';
    final static char ATMARK = '@';


    public static String mask(String jsonString) {
        try {
            if(false)
                return maskEmail(jsonString);

            Matcher m = Pattern.compile("(?=(@))").matcher(jsonString);
            List<Integer> positionList = new ArrayList<Integer>();
            while (m.find()) {
                positionList.add(m.start());
            }
            for (int index = 0; index < positionList.size(); index++) {
                String semiFinalString = maskEmailbeforeAtmark(jsonString,
                        positionList.get(index),ASTERICK);
                String finalString = maskEmailAfterAtmark(semiFinalString,
                        positionList.get(index),ASTERICK);
                jsonString = new String(finalString);
            }
            return jsonString;
        }catch(Exception e) {
            return jsonString;
        }
    }



    /**
     * This method will stark masking before the Atmark(`@`) identifier.
     *
     * @param str
     * @return masked json String.
     * 
     */
    private static String maskEmailbeforeAtmark(String str, int index,char replacementCharacter) throws Exception{
        StringBuffer buff = new StringBuffer(str);
        char[] chars = str.toCharArray();
        loop: for (int i = index - 1; i >= 0; i--) {

            if (chars[i] == QUOTATION_MARK) {
                buff.replace(i+1, i + 2, Character.toString(chars[i + 1]));
                buff.replace(i + 2, i + 3, Character.toString(chars[i + 2]));
                buff.replace(i + 3, i + 4, Character.toString(chars[i + 3]));

                break loop;
            } else {
                buff.replace(i, i + 1, Character.toString(replacementCharacter));
            }
        }
        return buff.toString();
    }

    /**
     * This method will stark masking after the Atmark(`@`) identifier.
     *
     * @param str
     * @return masked json String.
     * 
     */
    private static String maskEmailAfterAtmark(String str, int index,char replacementCharacter) throws Exception{
        StringBuffer buff = new StringBuffer(str);
        char[] chars = str.toCharArray();
        loop: for (int i = index + 1; i <= str.length(); i++) {
            if (chars[i] == DOT)
                break loop;
            else
                buff.replace(i, i + 1, Character.toString(replacementCharacter));
        }
        return buff.toString();
    }

    /**
     * This method mask a part of the email string.
     *
     * @param email
     * @return number
     * 
     */

    private static boolean isJSONValid(String target) {
        try {
            new JSONObject(target);
        } catch (JSONException ex) {
            try {
                new JSONArray(target);
            } catch (JSONException ex1) {
                return false;
            }
        }
        return true;
    }

    private static String maskEmail(String email) throws Exception {

            int start = 0;
            int end = email.length();
            if (start > end)
                return email;

            String semiMaskedString = maskEmailbeforeAtmark("\""+email,email.indexOf(ATMARK)+1,ASTERICK);
            String editedString= semiMaskedString.substring(1, semiMaskedString.length());
            String finalString = maskEmailAfterAtmark(editedString,editedString.indexOf(ATMARK),ASTERICK);
            return finalString;
    }

}