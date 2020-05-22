SwingUtilities.invokeLater(new Runnable() {

    @Override
    public void run() {
        try {
            UIManager.setLookAndFeel(
               new SubstanceBusinessBlackSteelLookAndFeel());
        } catch (UnsupportedLookAndFeelException e) {
            throw new RuntimeException(e);
        }
    }
});