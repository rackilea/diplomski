public class ExecExample {
    public static void main(String[] args) throws Exception {
        Process p = Runtime.getRuntime().exec("notepad.exe test.txt");      
        System.out.println("Waiting for notepad to exit...");
        System.out.println("Exited with code " + p.waitFor());
    }
}