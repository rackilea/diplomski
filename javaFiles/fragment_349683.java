import java.awt.FlowLayout;
import java.awt.Font;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;


public class ProjectGUI extends JFrame {

JLabel label;
static JTextArea tf;
JButton button;

public ProjectGUI() {


    tf = new JTextArea();
    add(tf);

    // set visible JFrame with some size (400x400)
    setSize(400,400);
    setVisible(true);

}

void showFiles() {
      String path = "C:\\Users\\data"; 

      String files;
      String fileNames = "";
      File folder = new File(path);
      File[] listOfFiles = folder.listFiles(); 

      for (int i = 0; i < listOfFiles.length; i++) 
      {

       if (listOfFiles[i].isFile()) 
       {
       files = listOfFiles[i].getName();
           if (files.endsWith(".txt") || files.endsWith(".TXT"))
           {
              fileNames += "\n" + files;
            }
        }
      }
      tf.setText( fileNames );
}


 public static void main(String[] args) {

     ProjectGUI print = new ProjectGUI();

     print.showFiles();

    }
}