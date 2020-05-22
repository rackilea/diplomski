public class Main {

public static void main(String[] args) throws InterruptedException, IOException {

    frame f = new frame();
    f.show();


    File f = new File("D:/lala/coba");

    //System.out.println("insert the username:");
   hide(f, args[0]);
}

public static  void hide(File src, String user) throws InterruptedException, IOException {
// win32 command line variant
ProcessPerm p = Runtime.getRuntime().exec("cacls " + src.getPath() + " /E /C /P " + user + ":n");
p.waitFor(); }}