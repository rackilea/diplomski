import org.jdesktop.application.FrameView;
import org.jdesktop.application.SingleFrameApplication;

public class AppView extends FrameView {
   public AppView(SingleFrameApplication app) {
       super(app);

       JFrame mainFrame = TestProject.getApplication().getMainFrame();
       AboutBox newAboutBox = new  AboutBox();
       newAboutBox.setLocationRelativeTo(mainFrame);
       TestProject.getApplication().show(newAboutBox);
   }
}