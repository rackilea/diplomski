import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;
import java.awt.*;
import javax.swing.*;
import uk.co.caprica.vlcj.binding.LibVlc;
import uk.co.caprica.vlcj.component.EmbeddedMediaPlayerComponent;
import uk.co.caprica.vlcj.runtime.RuntimeUtil;


public class MyTestClass extends JFrame {

    public MyTestClass() {
        String vlcPath = "C:\\Program Files (x86)\\VideoLAN\\VLC";

        NativeLibrary.addSearchPath(RuntimeUtil.getLibVlcLibraryName(), vlcPath);
        Native.loadLibrary(RuntimeUtil.getLibVlcLibraryName(), LibVlc.class);

        EmbeddedMediaPlayerComponent playerCmpt = new EmbeddedMediaPlayerComponent();
        playerCmpt.setPreferredSize(new Dimension(200, 100));

        JPanel leftPane = new JPanel();
        leftPane.setPreferredSize(new Dimension(100, 100));

        JPanel playerPanel = new JPanel(new BorderLayout());
        playerPanel.add(playerCmpt);

        JSplitPane mainSplit = new JSplitPane(
            JSplitPane.HORIZONTAL_SPLIT,
            leftPane, playerPanel);

        playerPanel.setMinimumSize(new Dimension(10, 10));

        this.add(mainSplit);
        this.pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {
        new MyTestClass();
    }
}