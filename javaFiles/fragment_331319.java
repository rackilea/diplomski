public class COInScrollPane extends JFrame {

    public COInScrollPane(){
        super();
        initialize();
    }

    private void initialize(){
        this.setTitle("JFrame");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        final JScrollPane jMainScrollPane = getJMainScrollPane();
        this.add(jMainScrollPane);
        this.setSize(480, 339);
        Action action = new AbstractAction("Toggle CO") {

            @Override
            public void actionPerformed(ActionEvent e) {
                ComponentOrientation co = jMainScrollPane.getComponentOrientation().isLeftToRight() ?
                        ComponentOrientation.RIGHT_TO_LEFT : ComponentOrientation.LEFT_TO_RIGHT;
                jMainScrollPane.applyComponentOrientation(co);
                jMainScrollPane.revalidate();
                jMainScrollPane.repaint();
            }
        };
        add(new JButton(action), BorderLayout.SOUTH);
    }

    private JScrollPane getJMainScrollPane() {
        JScrollPane jMainScrollPane = new JScrollPane(getJMainPanel());
        jMainScrollPane.setViewportBorder(BorderFactory
                .createLineBorder(Color.GREEN));
        jMainScrollPane
                .applyComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        return jMainScrollPane;
    }

    private JPanel getJMainPanel() {
        JPanel jMainPanel = new JPanel();
        jMainPanel.add(new JButton("just a button"));
        jMainPanel.setBorder(BorderFactory.createLineBorder(Color.RED));
        return jMainPanel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new COInScrollPane().setVisible(true);

            }
        });
    }
}