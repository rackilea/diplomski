import javax.swing.UIDefaults;
import javax.swing.UIManager;

public class CountUIDefaults {

    public static void main(String[] args) throws Exception {
        System.out.println(System.getProperty("os.name")
            + " " + System.getProperty("os.version")
            + " " + System.getProperty("java.version"));
        UIManager.LookAndFeelInfo[] lfa =
            UIManager.getInstalledLookAndFeels();
        for (UIManager.LookAndFeelInfo lf : lfa) {
            UIManager.setLookAndFeel(lf.getClassName());
            UIDefaults uid = UIManager.getLookAndFeelDefaults();
            System.out.println("***"
                + " " + lf.getName()
                + " " + lf.getClassName()
                + " " + uid.size() + " entries");
        }
    }
}