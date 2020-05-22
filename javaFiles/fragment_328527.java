public class BaseTextAreaDemo {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                final JFrame frame = new JFrame("Base JTextArea App");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                JPanel textAreaPanel = getBaseTextArea();
                JScrollPane scrollPane = new JScrollPane(textAreaPanel)  {
                    @Override
                    public Dimension getPreferredSize() {
                        return new Dimension(300, 230);
                    }
                };

                frame.add(scrollPane);
                frame.pack();
                frame.setLocationByPlatform(true);
                frame.setVisible(true);
            }

            private JPanel getBaseTextArea() {
                JTextArea textArea = new JTextArea();
                textArea.setLineWrap(true);
                textArea.setWrapStyleWord(true);
                textArea.append("bla bla bla\n");
                textArea.append("new text here");
                JPanel panel = new JPanel(new BorderLayout());
                panel.setBackground(textArea.getBackground());
                panel.setBorder(textArea.getBorder());
                textArea.setBorder(null);
                panel.add(textArea, BorderLayout.PAGE_END);

                return panel;
            }
        });
    }
}