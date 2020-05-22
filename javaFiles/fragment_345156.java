public class TranslucentWindow {

    public static void main(String[] args) {
        new TranslucentWindow();
    }

    public TranslucentWindow() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JWindow window = new JWindow();
                window.setSize(100, 100);
                window.setBackground(new Color(255, 0, 0, 128));
                window.setLocationRelativeTo(null);
                window.setVisible(true);

            }
        });
    }

}