import java.awt.datatransfer.*;
    import java.awt.*;
    /**
     * Demo to access System Clipboard
     */
    public class SystemClipboardAccess {

        public static void main(String args[])throws Exception
        {

            // Create a Clipboard object using getSystemClipboard() method
            Clipboard c=Toolkit.getDefaultToolkit().getSystemClipboard();

            // Get data stored in the clipboard that is in the form of a string (text)
            System.out.println(c.getData(DataFlavor.stringFlavor));
        }
    }