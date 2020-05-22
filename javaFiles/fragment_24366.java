public class RemoveHZ {
    public static String deal(String s) {
        StringBuffer sb = new StringBuffer(s);
        StringBuffer se = new StringBuffer();    //store final results
        int l = sb.length();
        char c;
        for (int i = 0; i < l; i++) {
            c = sb.charAt(i);                   //get each char from string
            if (Character.UnicodeScript.of(c) != Character.UnicodeScript.HAN) {
                se.append(c);
            }
        }
        return new String(se);
    }

    public static void main(String[] args) {
        System.out.println(deal("hello你好啊"));
    }
}