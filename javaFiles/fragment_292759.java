doLater {
    final MainFrame m = new MainFrame();
    doOutside {
        // handle heavy operation
        final int result = 1;
        doLater {
            m.setResult(result);
        }
    }
}