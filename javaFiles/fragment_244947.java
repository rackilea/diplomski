// atributes
private static JMenuItem editPaste;
private static Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard(); 
// private method
clipboard.addFlavorListener(new ListenerPaste());
editPaste = new JMenuItem(new DefaultEditorKit.PasteAction());
editPaste.setEnabled(false);
// listener 
private static class ListenerPaste implements FlavorListener {
    public void flavorsChanged(FlavorEvent e) {
        checkPaste();
    }
}
// private method
private static void checkPaste() {
    try {
        if(clipboard.getData(DataFlavor.stringFlavor) != null) {
            editPaste.setEnabled(true);
            // JOptionPane.showMessageDialog(null, (String) clipboard.getData(DataFlavor.stringFlavor));
        }
    } catch (UnsupportedFlavorException e1) {
        e1.printStackTrace();
    } catch (IOException e1) {
        e1.printStackTrace();
    }
}
// in constructor we check it also
checkPaste();