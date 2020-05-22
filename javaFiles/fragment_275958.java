import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.security.*;

public class localfile extends Applet {

private static final long serialVersionUID = 1L;

public localfile() {
  Panel p = new Panel();
  p.add(new Button("Call from Java"));
  add("North",p);
}

public void openFile(String path) {
  System.out.println("File: " + path);
  final File ffile = new File(path);
  System.out.println("Got file.");
  if (Desktop.isDesktopSupported()) {
    System.out.println("Desktop is supported.");
    final Desktop desktop = Desktop.getDesktop();
    System.out.println("Got Desktop Handle.");
    AccessController.doPrivileged(new PrivilegedAction() {
      public Object run() {
        try {
          desktop.open(ffile);
        } catch(Exception ex) {
          ex.printStackTrace();
        }
        return null;
      }
    });
    System.out.println("File Opened.");
  }
}

public boolean action(Event evt, Object arg) {
  openFile("/Users/conor/1.txt");
  return true;
}

}