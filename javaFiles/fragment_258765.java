import java.io.File;
import javax.swing.JFileChooser;
public class JFileChooserTest
{
  public static void main(String[] args)
  {
    System.out.println("file.encoding=" + System.getProperty("file.encoding"));
    String path;

    if(args.length > 0)
      path = args[0];
    else
      path = System.getProperty("user.dir", ".");

    File dir = new File(path);

    JFileChooser jfc = new JFileChooser(dir);
    int result = jfc.showOpenDialog(null);

    switch(result) {
      case JFileChooser.CANCEL_OPTION:
        System.out.println("User cancelled OPEN dialog.");
        break;
      case JFileChooser.APPROVE_OPTION:
        System.out.println("User chose file: " + jfc.getSelectedFile());
        break;
      case JFileChooser.ERROR_OPTION:
        System.out.println("User encountered an error");
        break;
     default:
       System.out.println("Confused");
       break;
    }

    System.exit(0);
  }
}