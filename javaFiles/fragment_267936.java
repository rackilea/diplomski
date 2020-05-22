public class InJava extends Applet{

  public void sayHello() {

    final String parametro = getParameter("parametro");

    FileInputStream fis =  AccessController.doPrivileged(new PrivilegedAction<FileInputStream>() {
      public FileInputStream run() {
        try  {
          retrun new FileInputStream(parametro);
        } catch (IOException e)  {
          // handle exception
        }
      }
    });
  }