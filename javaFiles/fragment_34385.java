import java.io.PrintStream;
class Kyrill {
    public static void main(String args[])
        throws java.io.UnsupportedEncodingException
    {
        String ru = "Русский язык";
        PrintStream ps = new PrintStream(System.out, true, "UTF-8");
        System.out.println(ru.length());
        System.out.println(ru);
        ps.println(ru);
    }
}

D:\Temp :: chcp 65001
Aktive Codepage: 65001.

D:\Temp :: javac -encoding utf-8 Kyrill.java && java Kyrill
12
??????? ????
Русский языкй язык