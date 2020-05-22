final String str = "one";

SwingUtilities.invokeLater(new Runnable() {
    @Override
    public void run() {
        Play game = new Play(str);
        game.setVisible(true);
    }
});