text.addKeyListener(new KeyAdapter() {
    @Override
    public void keyPressed(KeyEvent e)
    {
        if (e.stateMask == SWT.CTRL && e.keyCode == 'a') {
            text.selectAll();
            e.doit = false;
        }
    }
});