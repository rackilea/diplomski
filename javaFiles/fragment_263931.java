import java.io.*;
import javax.swing.*;

public class TextIntoTextArea {
   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            createAndShowGui();
         }
      });
   }

   private static void createAndShowGui() {
      JFileChooser fileChooser = new JFileChooser();
      int response = fileChooser.showOpenDialog(null);
      if (response == JFileChooser.APPROVE_OPTION) {
         File file = fileChooser.getSelectedFile();
         BufferedReader br = null;
         try {
            br = new BufferedReader(new FileReader(file));
            final JTextArea textArea = new JTextArea(20, 40);

            textArea.read(br, null); // here we read in the text file

            JOptionPane.showMessageDialog(null, new JScrollPane(textArea));
         } catch (FileNotFoundException e) {
            e.printStackTrace();
         } catch (IOException e) {
            e.printStackTrace();
         } finally {
            if (br != null) {
               try {
                  br.close();
               } catch (IOException e) {
               }
            }
         }
      }
   }
}