try {
    UIManager.setLookAndFeel(new SyntheticaAluOxideLookAndFeel());
} catch (UnsupportedLookAndFeelException e) {
    e.printStackTrace();
} catch (ParseException e) {
    e.printStackTrace();
}
EventQueue.invokeLater(new Runnable() {
    public void run() {
        JFrame frame = new JFrame();
        …
        frame.pack(true);
        frame.setVisible(true);
    }
});