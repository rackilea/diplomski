word.addKeyListener(new org.eclipse.swt.events.KeyAdapter() {
    public void keyPressed(org.eclipse.swt.events.KeyEvent e) {
        if (e.keyCode == SWT.CR) {
            System.out.println("worked!!!");
            status.setText("ababahalamaha");
            status.getParent().layout();
        }
    }
});