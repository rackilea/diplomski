public class Sample {
    public static void main(String[] args) throws Exception {
        // try to print Upper case A with ogonek
        System.out.println(new String(new byte[] {(byte) 164}, Charset.forName("IBM852"))); // <--- will print the correct character
        System.out.println(new String(new byte[] {(byte) 164}, Charset.forName("ISO-8859-2"))); // <--- will print something else
    }
}