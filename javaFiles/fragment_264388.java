public static void main(String[] args) {

    SwingUtilities.invokeLater(() -> {

        JFrame frame = new JFrame();
        frame.add(new HomeTopPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    });
}