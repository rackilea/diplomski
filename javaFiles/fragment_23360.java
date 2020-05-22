if(gt != null) {
        try {
            gt.setRunning(false);
            gt.join();
            gt = null;

        } catch (InterruptedException e) {
            Toast.makeText(c, "An error occured when stopping the thread.", Toast.LENGTH_LONG)
                    .show();
        }
    }