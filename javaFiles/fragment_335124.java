public class AddFont extends MainFrame {

    private static Font ttfBase = null;
    private static Font telegraficoFont = null;
    private static InputStream myStream = null;
    private static final String FONT_PATH_TELEGRAFICO = "imageFolder/TELEGRAFICO.TTF";

    public Font createFont() {


            try {
                myStream = new BufferedInputStream(
                        new FileInputStream(FONT_PATH_TELEGRAFICO));
                ttfBase = Font.createFont(Font.TRUETYPE_FONT, myStream);
                telegraficoFont = ttfBase.deriveFont(Font.PLAIN, 24);               
            } catch (Exception ex) {
                ex.printStackTrace();
                System.err.println("Font not loaded.");
            }
            return telegraficoFont;
    }
}