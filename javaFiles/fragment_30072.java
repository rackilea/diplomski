public class DesktopTest {

    public static void main(String args[]) {

        if (!Desktop.isDesktopSupported()) {
            System.err.println("Desktop not supported!");
            System.exit(-1);
        }

        Desktop desktop = Desktop.getDesktop();
        File file = new File(args[0]);

        if (desktop.isSupported(Desktop.Action.OPEN)) {
            try {
                desktop.open(file);
            }
            catch (IOException ioe) {
                System.err.println("Unable to open: " + file.getName());
            }
        }
    }
}