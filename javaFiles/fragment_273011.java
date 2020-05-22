import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class TestEmail {

    public static void main(String[] args) {
        if (Desktop.isDesktopSupported()) {
            Desktop desktop = Desktop.getDesktop();
            if (desktop.isSupported(Desktop.Action.MAIL)) {
                String mailTo = "sendto@somwhere.com";
                URI uriMailTo = null;
                try {
                    if (mailTo.length() > 0) {
                        System.out.println("Mail to " + mailTo);
                        uriMailTo = new URI("mailto", mailTo,  "This is a message");
                        desktop.mail(uriMailTo);
                    } else {
                        System.out.println("Mail");
                        desktop.mail();
                    }
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                } catch (URISyntaxException use) {
                    use.printStackTrace();
                }
            }
        }
    }

}