public static void createDialog(Button b, final String message) {
    //                                    ^^^^^
    MouseListener mouseListener = new MouseAdapter() {
        public void mousePressed(MouseEvent mouseEvent) {
            if (SwingUtilities.isLeftMouseButton(mouseEvent)) {
                JOptionPane.showConfirmDialog(null,
                        message, message, JOptionPane.YES_NO_OPTION);
            }
        }
    };
}