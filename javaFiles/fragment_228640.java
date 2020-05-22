synchronized (lockObject) {
        while (currentAnalysis == null) {
            try { lockObject.wait(); }
            catch Exception(e) { } // FIXME: ignores exception
        }
    }
    currentAnalysis.cancel();