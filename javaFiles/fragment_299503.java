public class TestClipboard {

    public static void main(String[] args) {

        String initial = "";
        while (true) {
            try {
                Clipboard c = Toolkit.getDefaultToolkit().getSystemClipboard();
                String paste = c.getContents(null).getTransferData(DataFlavor.stringFlavor).toString();
                if (!paste.equals(initial)) {
                    System.out.println(paste);
                    initial = paste;
                }
            } catch (UnsupportedFlavorException | IOException ex) {
                Logger.getLogger(TestClipboard.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                Thread.sleep(40);
            } catch (InterruptedException ex) {
            }
        }
    }   
}