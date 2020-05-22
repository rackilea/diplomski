frame.setContentPane(htmlPanel);
frame.setVisible(true);
SwingUtilities.invokeLater(new Runnable() {
    @Override
    public void run() {
        htmlPanel.scroll(500, 300);
    }
});