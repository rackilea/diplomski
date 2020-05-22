public class TestMain {

    public static void main(String args[]) {
        byte[] badChars = new byte[10]; // all bytes are 0
        String test = "Middle";
        for (int i = 0;i < test.length() && i < badChars.length; ++i) {
            badChars[i] = (byte) test.charAt(i);
        }        
        String a = new String(badChars);        
        System.out.println(a);        
        String p = "Before " + new String(badChars) + " After";
        System.out.println(p);
    }
}