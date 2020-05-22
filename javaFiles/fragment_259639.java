package java.lang;

public class FastConcat {

    public static String concat(String s1, String s2){
        s1=String.valueOf(s1);//null checks
        s2=String.valueOf(s2);

        return s1.concat(s2);
    }

    public static String concat(String s1, String s2, String s3){
        s1=String.valueOf(s1);//null checks
        s2=String.valueOf(s2);
        s3=String.valueOf(s3);
        int len = s1.length()+s2.length()+s3.length();
        char[] c = new char[len];
        int idx=0;
        idx = copy(s1, c, idx);
        idx = copy(s2, c, idx);
        idx = copy(s3, c, idx);
        return newString(c);
    }
    public static String concat(String s1, String s2, String s3, String s4){
        s1=String.valueOf(s1);//null checks
        s2=String.valueOf(s2);
        s3=String.valueOf(s3);
        s4=String.valueOf(s4);

        int len = s1.length()+s2.length()+s3.length()+s4.length();
        char[] c = new char[len];
        int idx=0;
        idx = copy(s1, c, idx);
        idx = copy(s2, c, idx);
        idx = copy(s3, c, idx);
        idx = copy(s4, c, idx);
        return newString(c);

    }
    private static int copy(String s, char[] c, int idx){
        s.getChars(c, idx);
        return idx+s.length();

    }
    private static String newString(char[] c){
        return new String(0, c.length, c);
        //return String.copyValueOf(c);//if not in java.lang
    }
}