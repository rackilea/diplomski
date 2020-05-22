public class BadLayout01 {

    public static void main(String[] args) {
        new BadLayout01();
    }

    public BadLayout01() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException ex) {
                } catch (InstantiationException ex) {
                } catch (IllegalAccessException ex) {
                } catch (UnsupportedLookAndFeelException ex) {
                }

                ShapeFrame shapeFrame = new ShapeFrame();
                shapeFrame.setSize(525, 525);
                shapeFrame.setVisible(true);

            }
        });
    }

    public class ShapeFrame extends JFrame {

        private JPanel outlinePanel;

        public ShapeFrame() {
            super("Outline / Abstract Image");
            setSize(950, 500);
            setLayout(null);
            getContentPane().setBackground(Color.BLACK);
//            setBackground(Color.BLACK);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JPanel outlinePanel = new JPanel();
            outlinePanel.setBackground(Color.WHITE);
            outlinePanel.setBorder(null);
            outlinePanel.setBounds(50, 50, 400, 400);
            add(outlinePanel);


//      abstractPanel = new JPanel();
//      abstractPanel.setBackground(Color.WHITE);
//      abstractPanel.setBounds(500, 50, 400, 400);
//      add(abstractPanel);
        }
    }
}