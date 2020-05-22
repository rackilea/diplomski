/**
 * @param args
 */
public static void main(String[] args) {
    byte[]  result = {1,2,3,4,5,6,7,8};
    String str;
    try {
        str = new String (result, "ISO-8859-1" ).trim();
        str  =  Arrays.toString(result).trim();
        str = str.replaceAll(" ","");
        System.out.println ( "str = ["+str+"]");
    } catch (UnsupportedEncodingException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    // TODO Auto-generated method stub

}