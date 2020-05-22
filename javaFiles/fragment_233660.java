Bundle bundle = Platform.getBundle("org.mozilla.xulrunner"); //$NON-NLS-1$  
if (bundle != null) {
    URL resourceUrl = bundle.getResource("xulrunner"); //$NON-NLS-1$
    if (resourceUrl != null) {
        try {
            URL fileUrl = FileLocator.toFileURL(resourceUrl);
            File file = new File(fileUrl.toURI());
            System.setProperty("org.eclipse.swt.browser.DefaultType",
                    "mozilla");
            System.setProperty(
                    "org.eclipse.swt.browser.XULRunnerPath", file.getAbsolutePath()); //$NON-NLS-1$

        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
} else {
    System.err.println("Could not find XULrunner bundle");
}
Browser webBrowser = new Browser(parent, SWT.MOZILLA);
GridData grid = new GridData(GridData.FILL_BOTH);
webBrowser.setLayoutData(grid);
// Prepending "file://" prevents the "<driveletter> is not a registered protocol" error
String graphUrl = "file://C:/Users/you/yourGraph.html"
webBrowser.setUrl(graphUrl);