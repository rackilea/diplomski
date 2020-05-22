public static void loadCompletely (Image img) {

    MediaTracker tracker = new MediaTracker(new JPanel());
    tracker.addImage(img, 0);
    try {
        tracker.waitForID(0);
    } catch (InterruptedException ex) {
        throw new RuntimeException(ex);
    }
}