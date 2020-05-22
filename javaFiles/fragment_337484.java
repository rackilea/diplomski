public class Window {

    public Window(String title, Game game) {

        // Creates new JFrame
        JFrame frame = new JFrame(title);

        // Adds Game to window
        frame.add(game);
        frame.pack();

        // Settings of Window
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

}