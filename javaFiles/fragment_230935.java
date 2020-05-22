import java.awt.*;
import javax.swing.*;
import java.net.URL;

class LoadFont {
    public static void main(String[] args) throws Exception {
        // This font is < 35Kb.
        URL fontUrl = new URL("http://www.webpagepublicity.com/" +
            "free-fonts/a/Airacobra%20Condensed.ttf");
        Font font = Font.createFont(Font.TRUETYPE_FONT, fontUrl.openStream());
        GraphicsEnvironment ge = 
            GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(font);
        JList fonts = new JList( ge.getAvailableFontFamilyNames() );
        JOptionPane.showMessageDialog(null, new JScrollPane(fonts));
    }
}