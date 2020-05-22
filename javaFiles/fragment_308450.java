@Test
public void test() throws Exception {
    final Shell shell = new Shell();
    final Browser browser = new Browser(shell, SWT.WEBKIT);
    browser.setText("Hello World!");
    shell.open();
    while (shell.getDisplay().readAndDispatch()) {
        // Loop here in case there is more than one event in the queue
        // Also, it may be advised to call Display.sleep() here as well
    }
    Assert.assertEquals("Hello World!", browser.getText());
}