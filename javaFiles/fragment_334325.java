import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JViewport;
import javax.swing.ScrollPaneConstants;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.ViewportLayout;

class Frame extends JFrame {

    private JPanel panelLeft;
    private JScrollPane scrollPane;
    private JPanel movingPanel;
    private JPanel upper;
    private JPanel lower;
    private boolean inited;
    private JLabel labelUpper;
    private JLabel labelLower;
    private JButton scrollBtn;
    private Frame.PanelSlideController panelSlideController;
    private JButton resizeBtn;

    private boolean lowerShowing = false;

    public Frame() {
        getContentPane().setLayout(new BorderLayout());

        panelLeft = new JPanel();
        panelLeft.setBackground(Color.CYAN);
        panelLeft.setPreferredSize(new Dimension(300, 400));
        getContentPane().add(panelLeft, BorderLayout.WEST);

        labelUpper = new JLabel("upper");
        panelLeft.add(labelUpper);

        labelLower = new JLabel("lower");
        panelLeft.add(labelLower);

        scrollBtn = new JButton("Scroll");
        scrollBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                doScroll();
            }
        });
        panelLeft.add(scrollBtn);

        scrollPane = new JScrollPane();
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        movingPanel = new JPanel(new GridLayout(2, 1));
        movingPanel.setOpaque(false);
        movingPanel.setPreferredSize(new Dimension(300, 400));

        upper = new JPanel();
        upper.setBackground(Color.YELLOW);
        movingPanel.add(upper);

        lower = new JPanel();
        lower.setBackground(Color.RED);
        movingPanel.add(lower);

        // ------------------------------
        // This is the key bit
        // ------------------------------
        JViewport viewport = new JViewport() {
            @Override
            protected LayoutManager createLayoutManager() {
                return new ViewportLayout() {

                    @Override
                    public void layoutContainer(Container parent) {
                        JViewport vp = (JViewport) parent;
                        Component view = vp.getView();

                        Dimension viewPrefSize = view.getPreferredSize();
                        Dimension vpSize = vp.getSize();
                        Dimension viewSize = new Dimension(viewPrefSize);

                        viewSize.width = vpSize.width;
                        viewSize.height = vpSize.height * 2;

                        vp.setViewSize(viewSize);
                    }
                };
            }

        };
        scrollPane.setViewport(viewport);
        viewport.setView(movingPanel);
        // ------------------------------
        // End of key bit
        // ------------------------------

        getContentPane().add(scrollPane, BorderLayout.EAST);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();

        inited = true;
    }

    protected void doScroll() {
        panelSlideController = new PanelSlideController(scrollPane, 20);
        int scrollDirection = lowerShowing ? -1 : 1;
        panelSlideController.scrollY(panelLeft.getHeight() * scrollDirection);
        lowerShowing = !lowerShowing;
    }

    @Override
    public void validate() {
        super.validate();

        System.out.println("Validating");
        if (inited) {
            labelUpper.setText("upper: " + upper.getSize().height);
            labelLower.setText("lower: " + lower.getSize().height);
        }
    }

    class PanelSlideController implements ActionListener {

        private final JScrollPane scrollPane;
        private final int speed;
        private Timer timer;
        private int endPos;

        private boolean scrollingPositive;

        public PanelSlideController(JScrollPane scrollPane, int speed) {
            this.scrollPane = scrollPane;
            this.speed = speed;
        }

        public void scrollY(int scrollDistance) {
            endPos = scrollPane.getViewport().getViewPosition().y + scrollDistance;
            scrollingPositive = scrollDistance > 0;
            timer = new Timer(speed, this);
            timer.start();
        }

        public void redraw() {
            JViewport viewport = scrollPane.getViewport();
            Point position = viewport.getViewPosition();

            if (scrollingPositive) {
                position.y = endPos;
            }
            else {
                position.y = 0;
            }
            viewport.setViewPosition(position);

        }

        @Override
        public void actionPerformed(ActionEvent e) {
            JViewport viewport = scrollPane.getViewport();
            Point position = viewport.getViewPosition();
            int offset = scrollingPositive ? 10 : -10;
            position.y += offset;
            viewport.setViewPosition(position);

            if ((scrollingPositive && position.y >= endPos)
                    || (!scrollingPositive && (position.y <= endPos || position.y <= 0))) {
                timer.stop();
            }
        }
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frame().setVisible(true);
            }
        });
    }
}