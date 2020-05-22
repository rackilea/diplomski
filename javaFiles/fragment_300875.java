public class SimpleTicTacToe {

    public static void main(String[] args) {
        new SimpleTicTacToe();
    }

    public SimpleTicTacToe() {
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
                frame.add(new GamePane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class GamePane extends JPanel {

        public GamePane() {
            setLayout(new GridLayout(3, 3));
            for (int index = 0; index < 9; index++) {
                add(new JButton());
            }
        }

    }

}