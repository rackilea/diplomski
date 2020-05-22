public class KeyBindingsTest {

    public static void main(String[] args) {
        new KeyBindingsTest();
    }

    public KeyBindingsTest() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (Exception ex) {
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new KeyBindingPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public static class KeyBindingPane extends JPanel {

        private JTextArea textArea;

        public KeyBindingPane() {
            setLayout(new BorderLayout());
            add(new JScrollPane((textArea = new JTextArea())));

            InputMap im = getInputMap(WHEN_IN_FOCUSED_WINDOW);
            ActionMap am = getActionMap();

            im.put(KeyStroke.getKeyStroke(KeyEvent.VK_Z, KeyEvent.ALT_DOWN_MASK, false), "Released");
            im.put(KeyStroke.getKeyStroke(KeyEvent.VK_Z, KeyEvent.ALT_DOWN_MASK, true), "Pressed");

            am.put("Released", new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("released");
                    textArea.append("Released\n");
                }
            });
            am.put("Pressed", new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("pressed");
                    textArea.append("Pressed\n");
                }
            });

            setFocusable(true);
            requestFocusInWindow();
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(100, 100);
        }
    }
}