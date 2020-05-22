public class Test {

    public static Font font = null;

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    if (font == null) {
                        font = AddFont.createFont();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                createGUI();

            } // public void run() Closing
        });
    }
}