/**
  * Kills the MySQL process.
  */
    public synchronized void shutdown() {
        boolean haveShell = (getShell() != null);
        if (!pidFile().exists() && !haveShell) {
            printMessage("Mysqld not running. No file: " + pidFile());
            return;
        }
        printMessage("stopping mysqld (process: " + pid() + ")");

        issueNormalKill();

        if (processRunning()) {
            issueForceKill();
        }

        if (shellRunning()) {
            destroyShell();
        }
        setShell(null);

        if (processRunning()) {
            printWarning("Process " + pid + "still running; not deleting " 
                    + pidFile());
        } else {
            threads.pause(150);
            System.gc();
            threads.pause(150);
            pidFile().deleteOnExit();
            pidFile().delete();
            pidFile = null;
            pid = null;
        }

        setReadyForConnection(false);

        printMessage("clearing options");
        options.clear();
        out.flush();

        printMessage("shutdown complete");
    }