private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {
System.out.println("KeyPressed " + evt);

if (evt.getKeyCode() == KeyEvent.VK_TAB) {
    evt.consume();

    int caretPos = jTextField1.getCaretPosition();
    try {
        final String newPrefix = jTextField1.getText(0, caretPos);
        System.out.println("newPrefix: " + newPrefix);
        if (!newPrefix.isEmpty()) {
            if (typedPrefix == null || !newPrefix.startsWith(typedPrefix)) {
                // Must physically reload possible values:
                String[] fileNames = dir.list(new FilenameFilter() {

                    @Override
                    public boolean accept(File dir, String name) {
                        return name.startsWith(newPrefix);
                    }
                });
                filesWithPrefix.clear();
                Collections.addAll(filesWithPrefix, fileNames);
                typedPrefix = newPrefix;
            } else {
                // Can reduce prior selection:
                for (ListIterator<String> it = filesWithPrefix.listIterator(); it.hasNext(); ) {
                    String fileName = it.next();
                    if (!fileName.startsWith(newPrefix)) {
                        it.remove();
                    }
                }
                typedPrefix = newPrefix;
            }
            System.out.println("filesWithPrefix: " +filesWithPrefix);
            if (!filesWithPrefix.isEmpty()) {
                // Find longest common prefix:
                String longestCommonPrefix = null;
                for (String fileName : filesWithPrefix) {
                    if (longestCommonPrefix == null) {
                        longestCommonPrefix = fileName;
                    } else {
                        while (!fileName.startsWith(longestCommonPrefix)) {
                            longestCommonPrefix = longestCommonPrefix.substring(0, longestCommonPrefix.length() - 1);
                        }
                    }
                }
                if (longestCommonPrefix.length() > typedPrefix.length()) {
                    jTextField1.setText(longestCommonPrefix);
                    jTextField1.setCaretPosition(longestCommonPrefix.length());
                    typedPrefix = longestCommonPrefix;
                }
                if (filesWithPrefix.size() > 1) {
                    // Show popup:
                    ;;;
                } else if (filesWithPrefix.size() == 1) {
                    // File selected:
                    System.beep();
                }
            }
        }
    } catch (BadLocationException ex) {
        Logger.getLogger(TabsJFrame.class.getName()).log(Level.SEVERE, null, ex);
    }
}
}