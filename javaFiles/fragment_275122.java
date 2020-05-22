myStlyedText.addMouseListener(new MouseListener() {
    @Override
    public void mouseUp(MouseEvent e) {
        System.out.println("MouseUp is fired");
    }

    @Override
    public void mouseDown(MouseEvent e) {
        if (certainStringClicked()) {
            myStlyedText.notifyListeners( SWT.MouseUp, null );
            openDialog();
        }
    }

    @Override
    public void mouseDoubleClick(MouseEvent e) {}
});