public class TestLocation01 {

    public static void main(String[] args) {
        new TestLocation01();
    }

    public TestLocation01() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JPanel outter = new JPanel(new BorderLayout());
                outter.setBorder(new CompoundBorder(new LineBorder(Color.RED), new EmptyBorder(10, 10, 10, 10)));
                JPanel inner = new JPanel(new GridBagLayout());
                inner.setBorder(new CompoundBorder(new LineBorder(Color.BLUE), new EmptyBorder(10, 10, 10, 10)));
                JLabel label = new JLabel("Testing");
                inner.add(label);
                outter.add(inner);

                JLabel below = new JLabel("Below");

                JFrame frame = new JFrame("Test");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(outter);
                frame.add(below, BorderLayout.SOUTH);
                frame.setSize(200, 200);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);

                System.out.println("lable.location: " + label.getLocation());
                System.out.println("label to inner: " + SwingUtilities.convertPoint(label, new Point(0, 0), inner));
                System.out.println("label to outter: " + SwingUtilities.convertPoint(label, new Point(0, 0), outter));
                System.out.println("label.parent to inner: " + SwingUtilities.convertPoint(label.getParent(), new Point(0, 0), inner));
                System.out.println("label.parent to outter: " + SwingUtilities.convertPoint(label.getParent(), new Point(0, 0), outter));
                System.out.println("label to frame: " + SwingUtilities.convertPoint(label, new Point(0, 0), frame));
                System.out.println("label.getParent to frame: " + SwingUtilities.convertPoint(label.getParent(), new Point(0, 0), frame));
                System.out.println("outter to label: " + SwingUtilities.convertPoint(outter, new Point(0, 0), label));
                System.out.println("label to below: " + SwingUtilities.convertPoint(label, new Point(0, 0), below));
                System.out.println("below to label: " + SwingUtilities.convertPoint(below, new Point(0, 0), label));
            }
        });
    }        
}