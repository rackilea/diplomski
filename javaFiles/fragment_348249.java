public class SubObj extends JPanel {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame();
                SubObj content = new SubObj();
                frame.setContentPane(content);
                frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }

    SubObj() {
        MouseAdapter mouseAdapter = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println(e.getSource());
                System.out.println("click from " + ((TestPanel) e.getSource()).getId());
            }
        };

        JPanel testPanel1 = new TestPanel("1");
        testPanel1.setPreferredSize(new Dimension(200, 200));
        testPanel1.setBackground(Color.BLACK);
        testPanel1.addMouseListener(mouseAdapter);
        add(testPanel1);

        JPanel testPanel2 = new TestPanel("2");
        testPanel2.setPreferredSize(new Dimension(100, 100));
        testPanel2.setBackground(Color.RED);
        testPanel2.addMouseListener(mouseAdapter);
        add(testPanel2);
    }

    private class TestPanel extends JPanel {
        private String id;

        TestPanel(String id) {
            this.id = id;     
        }

        public String getId() {
            return id;
        }
    }
}