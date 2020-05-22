SwingUtilities.invokeLater(new Runnable() {

    @Override
    public void run() {
        try {
            UIManager.setLookAndFeel(
               new SubstanceBusinessBlackSteelLookAndFeel());
            SwingUtilities.updateComponentTreeUI(frame);
        } catch (UnsupportedLookAndFeelException e) {
            throw new RuntimeException(e);
        }
    }
});