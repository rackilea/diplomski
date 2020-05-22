class MyLoginPanel extends JPanel implements ActionListener {
    private final ProgressListener listener;

    public MyLoginPanel(ProgressListener listener) {
        // Components, etc.
        this.listener = listener;
    }

        ...

    /** */
    @Override
    public void actionPerformed(ActionEvent e) {
        // Validate login, or whatever.
        // All went well, notify listener to progress.
        this.listener.progressFrom(AppState.LOGIN);
    }
}