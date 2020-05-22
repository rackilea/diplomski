public class Undeletable {

    public static void main(String[] args) {

        Runtime runtime=Runtime.getRuntime();
        try {
            Process process= runtime.exec("cmd.exe /c  start cacls text.txt /e /d %username%");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    } 


}