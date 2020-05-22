// Libraries to set clipboard
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Clipboard;

public class tester{

 public static void main(String[] args){

     // from string to clipboard
    StringSelection selection = new StringSelection("hi");
    Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
    clipboard.setContents(selection, selection);
 }
}