reduceButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent arg0) {
        size -= 4;
        System.out.println("FontSize = " + size);
        // Font has changed, instantiate a new FontSizeAction and execute it immediately.
        new StyledEditorKit.FontSizeAction("myaction-", size).actionPerformed(arg0);
    }
});