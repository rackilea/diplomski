private void textoKeyReleased(javax.swing.event.CaretEvent evt) {
    int end = textPane.getSelectionEnd();
    StyledDocument doc = textPane.getStyledDocument();

    Style style = textPane.getStyle("negra");
    StyleConstants.setBold(style, car == 1);
    doc.setCharacterAttributes(end - 1, 1, style, false);
    textPane.requestFocus();
}

@Override
public void keyTyped(KeyEvent e) {
    SwingUtilities.invokeLater(new Runnable() {         
        @Override
        public void run() {
            textoKeyReleased(null);
        }
    });
}