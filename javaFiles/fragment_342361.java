Text text1 = new Text(shell, SWT.MULTI | SWT.WRAP);
text1.setBounds(10,10,150,50);
text1.setText("Tab will traverse out from here.");
text1.addTraverseListener(new TraverseListener() {
    public void keyTraversed(TraverseEvent e) {
        if (e.detail == SWT.TRAVERSE_TAB_NEXT || e.detail == SWT.TRAVERSE_TAB_PREVIOUS) {
            e.doit = true;
        }
    }
});