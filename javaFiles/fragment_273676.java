public class SwapLastChars {

    static String testcase1 = "A";

    public static void main(String args[]) {
        SwapLastChars testInstance = new SwapLastChars();
        String result = testInstance.swap(testcase1);
        System.out.println(result);
    }

    public String swap(String str1) {
        if(str1 == null || str1.length() < 2) { //Move here
            return str1;
        }
        String str = "";
        int length = str1.length();
        char last = str1.charAt(length - 1);
        char l = str1.charAt(length - 2);
        for(int i = 0; i < str1.length() - 2; i++) {
            str = str + str1.charAt(i);
        }
        str = str + last + l;
        return str;
    }
}