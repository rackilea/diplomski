Thread rowAgeUpdater = new Thread() {

        @Override
        public void run () {
            while (isAlive()) {
                try {

                    long time = System.currentTimeMillis();
                    long sleepTime = (time / 1000 + 1) * 1000 - time;
                    Thread.sleep(sleepTime);

                    SwingUtilities.invokeAndWait(new Runnable() {
                        public void run () {
                            model.updateColumn(ROW_AGE_COLUMN_INDEX);
                        }
                    });

                } catch (Exception e) {
                    return;
                }

            }
        }
    };
    rowAgeUpdater.setDaemon(true);
    rowAgeUpdater.setPriority(Thread.MIN_PRIORITY);
    rowAgeUpdater.start();