import java.io.File;    
import javax.swing.JTextField;  
import netx.jnlp.JNLPFile;
import netx.jnlp.Launcher;
import org.junit.Assert;
import org.junit.Test;
import org.uispec4j.Trigger;
import org.uispec4j.UISpecAdapter;
import org.uispec4j.UISpecTestCase;
import org.uispec4j.Window;
import org.uispec4j.interception.WindowInterceptor;

public class WebstartTest extends UISpecTestCase {

    @Test
    public void test() throws Exception {
        // click your webdriver link, save the jnlp file to disk
        final File file = new File("file.jnlp");
        final JNLPFile jnlp = new JNLPFile(file.toURI().toURL());

        // adapter is a UISpec4j way to allow capturing windows created in 
        // non-standard way, exactly what we need.
        this.setAdapter(new UISpecAdapter() {
            @Override
            public Window getMainWindow() {
                return WindowInterceptor.run(new Trigger() {
                    @Override
                    public void run() throws Exception {
                        // running jnlp by netx launcher 
                        Launcher launcher = new Launcher();
                        launcher.setCreateAppContext(false);
                        launcher.launch(jnlp);
                    }
                });
            }
        });

        Window w = this.getMainWindow();

        // verify if window's components are there
        Assert.assertEquals("text", ((JTextField) w.getSwingComponents(JTextField.class)[0]).getText());

        // manipulate window components...
    }
}