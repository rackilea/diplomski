public static void main(String[] args) {
    try {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    EventQueue.invokeLater(() -> {
        new Game(new JFrame()).start();
    });
}