public class TestSeperator {

    public static void main(String[] args) {
        new TestSeperator();
    }

    public TestSeperator() {
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

                JFrame frame = new JFrame("Test");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new TestSeperatorPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestSeperatorPane extends JPanel {

        public TestSeperatorPane() {
            setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
            int counter = 1;
            add(new JSeparator(SwingConstants.HORIZONTAL)); //Here is the
            add(new JSeparator(SwingConstants.HORIZONTAL)); //problem
            JPanel p2 = new JPanel();
            int petsx = 4;
            int petsy = 4;
            for (int i = 0; i < petsx; i++) {
                for (int i2 = 0; i2 < petsy; i2++) {
                    p2.add(new JLabel(":)"));
                    p2.add(new JLabel("A"));
                    if (counter % petsx == 0) {
                        add(p2);
                        add(new JSeparator(SwingConstants.HORIZONTAL));
                        p2 = new JPanel();
                        counter = 0;
                    } else {
                        JSeparator js = new JSeparator(SwingConstants.VERTICAL);
                        // This is a bad idea...
                        //js.setPreferredSize(new Dimension(1, newPetHeight));
                        js.setBorder(new EmptyBorder(6, 0, 6, 0));
                        p2.add(js);
                    }
                    counter++;
                }
            }
        }
    }
}