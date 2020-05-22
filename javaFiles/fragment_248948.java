mntmNewGame.addKeyListener(new KeyAdapter() {
    @Override public void keyTyped(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_F2) {
            int n = JOptionPane.showConfirmDialog(
                contentPane,
                "Do you want to play new game ?",
                "Message!",
                JOptionPane.OK_CANCEL_OPTION);
            // Use n, presumably...
        }
    }
});