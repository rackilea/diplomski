public class TestGlobalPopup {

    public static void main(String[] args) {
        new TestGlobalPopup();
    }

    public TestGlobalPopup() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        public TestPane() {
            Toolkit.getDefaultToolkit().addAWTEventListener(new AWTEventListener() {
                @Override
                public void eventDispatched(AWTEvent event) {
                    if (event instanceof MouseEvent) {
                        MouseEvent me = (MouseEvent) event;
                        if (me.isPopupTrigger()) {
                            Component component = me.getComponent();
                            JPopupMenu popup = new JPopupMenu();
                            popup.add(new JLabel("Clicked on " + component.getClass().getName()));
                            popup.show(component, me.getX(), me.getY());
                        }
                    }
                }
            }, AWTEvent.MOUSE_EVENT_MASK);

            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            add(new JLabel("Label: "), gbc);
            gbc.gridx++;
            add(new JTextField(10), gbc);

            gbc.gridy++;
            gbc.gridx = 0;
            gbc.gridwidth = 2;
            add(new JScrollPane(new JTextArea(5, 20)), gbc);
        }

    }

}