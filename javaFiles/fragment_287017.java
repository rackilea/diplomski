public class FullScreenExample extends JFrame {

    public class FullScreen {
        private GraphicsDevice device;
        private JFrame frame;
        private boolean isFullScreen;

        public FullScreen() {
            frame = new JFrame();
            JPanel content = new JPanel();
            content.setLayout(new BorderLayout());
            frame.setContentPane(content);
            frame.setUndecorated(true);

            // Full screen escape
            frame.addKeyListener(new KeyListener() {
                @Override
                public void keyPressed(KeyEvent e) {
                    // Exit full screen when ESC pressed
                    if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                        exitFullScreen();
                    }
                }

                @Override
                public void keyReleased(KeyEvent e) {}

                @Override
                public void keyTyped(KeyEvent e) {}
            });
        }

        public void enterFullScreen() {
            if (!isFullScreen) {
                // Get the current device
                GraphicsConfiguration config = FullScreenExample.this.getGraphicsConfiguration();
                device = config.getDevice();

                // Remove the panel from the wrapper
                myWrapper.remove(myPanel);
                // Add the panel to the full screen frame
                frame.getContentPane().add(myPanel);
                // Set the full screen window
                device.setFullScreenWindow(frame);
                isFullScreen = true;
            }
        }

        public void exitFullScreen() {
            if (isFullScreen) {
                // Remove the fractal from the full screen frame
                frame.getContentPane().remove(myPanel);
                // Add the panel back to the wrapper
                myWrapper.add(myPanel);
                // Disable full screen
                device.setFullScreenWindow(null);
                // Dispose frame
                frame.dispose();
                // Revalidate window
                FullScreenExample.this.validate();
                isFullScreen = false;
            }
        }
    }

    /*
     * This example uses a main content panel, myPanel
     * and a wrapper to host the panel in the main JFrame, myWrapper.
     */
    private JPanel myPanel, myWrapper;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                FullScreenExample frame = new FullScreenExample();
                frame.init();
                frame.setVisible(true);
            }
        });
    }

    public void init() {
        // Generate example main window
        JPanel content = new JPanel();
        content.setBorder(new EmptyBorder(5, 5, 5, 5));
        content.setLayout(new BorderLayout());
        this.setContentPane(content);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        myPanel = new JPanel();
        myPanel.setBackground(Color.BLUE);

        // Full screen button and listener
        JButton fullscreen = new JButton("Full Screen");
        final FullScreen fs = new FullScreen();
        fullscreen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                fs.enterFullScreen();
            }
        });

        myWrapper = new JPanel();
        myWrapper.setLayout(new BorderLayout());
        myWrapper.add(myPanel);

        content.add(myWrapper, BorderLayout.CENTER);
        content.add(fullscreen, BorderLayout.SOUTH);
        this.setBounds(100, 100, 350, 350);
    }
}