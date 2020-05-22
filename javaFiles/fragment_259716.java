public class IOTest {
    public static void main(String[] args) {
        System.out.println("请在下面输入一行字符 ：\n");
        byte[] buffer = new byte[256]; // This line was added
        try {
            System.in.read(buffer,0,255);
        }
        catch(Exception e) {
            System.out.println("读取输入字符出错，错误信息为 ："+e.toString()+"\n");
        }
        System.out.println("您刚才输入的一行字符为 ：\n");
        String inputStr=new String(buffer,0);
        System.out.println(inputStr);
    }
}