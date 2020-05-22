import java.io.*;

class Test {

    public static void main(String[] args) throws IOException {
        StringBuffer buf = new StringBuffer();
        BufferedReader r = new BufferedReader(new FileReader("src/Test.java"));

        final String nl = System.getProperty("line.separator");
        String line;
        while (null != (line = r.readLine()))
            buf.append(line).append(nl);

        for (String code : buf.toString().split("(?ms)/\\*.*?\\*/|//[^\\n]*"))
            System.out.println(code);
    }
}