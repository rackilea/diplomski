public class BrowserTest {

    public static void main(String[] args) {
        Display display = new Display();
        Shell shell = new Shell(display);
        shell.setLayout(new FillLayout());

        Browser browser = new Browser(shell, SWT.NONE);
        browser.setUrl("file:/C:/BrowserTest/page.html");

        new JavaFunction(browser, "javaFunction");

        shell.pack();
        shell.open();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }
        display.dispose();
    }

    private static class JavaFunction extends BrowserFunction {

        JavaFunction(Browser browser, String name) {
            super(browser, name);
        }

        @Override
        public Object function(Object[] arguments) {
            System.out.println("Button pressed!");
            return null;
        }
    }

}