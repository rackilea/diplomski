SwingUtilities.invokeLater(new Runnable() {

    @Override
    public void run() {
        try {
            UIManager.setLookAndFeel(new GraphiteGlassSkinLookAndFeel());
            SwingUtilities.updateComponentTreeUI(frame);
        } catch (UnsupportedLookAndFeelException e) {
            throw new RuntimeException(e);
        }
    }
});