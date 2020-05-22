import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import uk.co.caprica.vlcj.component.EmbeddedMediaPlayerComponent;
import uk.co.caprica.vlcj.discovery.NativeDiscovery;

/**
 *
 * @author swhitehead
 */
public class Player {

    private final JFrame frame;

    int[] tools = new int[3];
    int[] vid1 = {1, 2, 3};
    int[] vid2 = {1, 3, 2};
    int[] vid3 = {2, 1, 3};
    int[] vid4 = {2, 3, 1};
    int[] vid5 = {3, 1, 2};
    int[] vid6 = {3, 2, 1};

    private final EmbeddedMediaPlayerComponent mediaPlayerComponent;

    public static void main(final String[] args) {
        new NativeDiscovery().discover();
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Player(args);
            }
        });
    }

    private List<String> inputs = new ArrayList<>(3);

    public Player(String[] args) {
        frame = new JFrame("Tutorials");
        frame.setSize(200, 200);
//        frame.setUndecorated(true);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                mediaPlayerComponent.release();
                System.exit(0);
            }
        });

        JPanel content = new JPanel(new BorderLayout());

        bindKey(content, KeyEvent.VK_1, "key1");
        bindKey(content, KeyEvent.VK_2, "key2");
        bindKey(content, KeyEvent.VK_3, "key3");
        bindKey(content, KeyEvent.VK_4, "key4");
        bindKey(content, KeyEvent.VK_5, "key5");
        bindKey(content, KeyEvent.VK_6, "key6");

        frame.setContentPane(content);

        mediaPlayerComponent = new EmbeddedMediaPlayerComponent();
        frame.add(mediaPlayerComponent);
        frame.setVisible(true);
        Canvas videoSurface = mediaPlayerComponent.getVideoSurface();
        mediaPlayerComponent.getVideoSurface().requestFocus();
//        mediaPlayerComponent.getMediaPlayer().playMedia("file location0");
//
//        if (tools == vid1) {
//            mediaPlayerComponent.getMediaPlayer().playMedia("file location1");
//        }

    }

    protected void bindKey(JComponent component, int keyCode, String name) {

        InputMap inputMap = component.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap actionMap = component.getActionMap();

        inputMap.put(KeyStroke.getKeyStroke(keyCode, 0, false), name + ".pressed");
        actionMap.put(name + ".pressed", new PressAction(name));
    }

    protected void inputDidChange() {
        System.out.println(inputs);
    }

    public class PressAction extends InputAction {

        public PressAction(String name) {
            super(name, true);
        }

    }

    public class ReleaseAction extends InputAction {

        public ReleaseAction(String name) {
            super(name, false);
        }

    }

    public class InputAction extends AbstractAction {

        private String name;
        private boolean pressed;

        public InputAction(String name, boolean pressed) {
            this.name = name;
            this.pressed = pressed;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            boolean didChange = false;
            if (pressed) {
                if (!inputs.contains(name)) {
                    while (inputs.size() > 2) {
                        inputs.remove(0);
                    }
                    inputs.add(name);
                    didChange = true;
                }
            } else {
                didChange = inputs.remove(name);
            }

            if (didChange) {
                inputDidChange();
            }
        }
    }

}