public void testWindow (TestRow window, String title) {
    closeWindow(window);
}

public void testWindow (TestColumn window, String title) {
    closeWindow(window);
}

private void closeWindow(CommonWindowsClass window) {
    if (window != null) {
        try {
            window.zClose(window);
        } catch (HarnessException e) {
            e.printStackTrace();
        }
        window = null;
    }
}