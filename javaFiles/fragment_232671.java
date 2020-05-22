import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import uk.co.caprica.vlcj.player.component.EmbeddedMediaPlayerComponent;
import uk.co.caprica.vlcj.player.embedded.OverlayApi;

public class AppFrame2 extends JFrame {

    private static final long serialVersionUID = -1569823648323129877L;

    public class OverlayPanel extends JPanel {

        private static final long serialVersionUID = 8070414617530302145L;

        private int x, y;
        private boolean ltr = true;

        public OverlayPanel() {
            this.setOpaque(false);
        }

        @Override
        public void paint(Graphics g) {

            super.paint(g);

            if (ltr) {
                if (x < 1180)
                    x += 1;
                else
                    ltr = false;
            } else {
                if (x < 0)
                    ltr = true;
                else
                    x -= 1;
            }

            g.setColor(Color.RED);
            g.fillRect(x, y, 100, 100);

            String s = Integer.toString(x);
            g.setColor(Color.WHITE);
            g.drawChars(s.toCharArray(), 0, s.length(), x+10, y+50);
        }
    }

    public class Overlay extends Window {

        private static final long serialVersionUID = 8337750467830040964L;

        OverlayPanel panel;

        public Overlay(Window owner) throws HeadlessException {
            super(owner);
            setBackground(new Color(0,0,0,0));

            panel = new OverlayPanel();
            this.add(panel);
        }
    }

    private EmbeddedMediaPlayerComponent appPlayer;

    public void createAndShowGUI() {

        appPlayer = new EmbeddedMediaPlayerComponent();
        appPlayer.setPreferredSize(new Dimension(1280, 800));
        getContentPane().add(appPlayer);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("App");
        setVisible(true);
        pack();

        Overlay overlay = new Overlay(this);

        OverlayApi api = appPlayer.mediaPlayer().overlay();
        api.set(overlay);
        api.enable(true);

        //appPlayer.mediaPlayer().media().play(" ... ");

        Timer timer = new Timer(0, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                overlay.panel.repaint();
            }
        });
        timer.setRepeats(true);
        timer.setDelay(17);
        timer.start();
    }
}