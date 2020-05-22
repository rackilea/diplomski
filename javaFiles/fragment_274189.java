SwingUtilities.invokeAndWait(new Runnable() {
    @Override
    public void run() {
        dp = new DrawPanel();

        setResizable(false);
        setSize(width, height);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle(title);
        setLocationRelativeTo(null);
        setContentPane(dp);
        setVisible(true);

        dp.init();
    }
});