try {
                    synchronized (this) {
                        wait(end - now);
                    }

                    // maybe a change triggers the wakup; we have to recalculate the
                    // wait time
                    now = System.currentTimeMillis();
                }
                catch (final InterruptedException e) {
                    LOG.error("InterruptedException while in waitForJobs", e);
                }