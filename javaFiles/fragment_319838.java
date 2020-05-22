public class OvalWindow {

            JFrame window;
            OvalPanel panel;

            int windowWidth = 500;
            int windowHeight = 500;

            /**
             * Run the program
             */
            public void run() {
                // Set a window
                window = new JFrame("Oval moving");
                window.setVisible(true);
                window.setSize(windowWidth, windowHeight);
                window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                // Create a panel and add it to the window
                panel = new OvalPanel();
                window.add(panel, BorderLayout.CENTER);

                panel.addMouseListener(new MouseAdapter() {
                    public void mouseClicked(MouseEvent e) {
                        panel.moveToCoord(e);
                    }
                });

            }

            public static void main(String[] args) {
                OvalWindow oWndow = new OvalWindow();
                oWndow.run();
            }

        }