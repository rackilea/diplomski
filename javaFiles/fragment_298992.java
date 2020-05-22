public class TestHTMLLabel {

    public static void main(String[] args) {
        new TestHTMLLabel();
    }

    public TestHTMLLabel() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                StringBuilder sb = new StringBuilder(64);
                sb.append("<html>I have something to say, it's beter to burn out then to fade away.").
                                append("  This is a very long String to see if you can wrap with in").
                                append("the available space</html>");

                JLabel label = new JLabel(sb.toString());

                JFrame frame = new JFrame("Test");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(label);
                frame.setSize(100, 100);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }    
        });
    }        
}