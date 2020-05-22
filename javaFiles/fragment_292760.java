doLater {
    final MainFrame m = new MainFrame();
    doOutside {
        // handle progress
        for(int i = 0; i < someSize; ++i) {
            final int progress = i;
            doLater {
                m.getProgressBar().setProgress(progress);
            }

        }
    }
}