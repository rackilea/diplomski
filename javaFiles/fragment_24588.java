public static void removeFileInfoForProvider(final int providerId) {
    Thread thread = new Thread() {
        @Override
        public void run() {
            removeFileInfoForProvider0(providerId);
        }
    };
    thread.start();
}

static synchronized void removeFileInfoForProvider0(final int providerId) {
    Iterator<Entry<String, FileInfo>> it = sFileInfoObjectList.entrySet().iterator();
    while (it.hasNext()) {
        Entry<String, FileInfo> pair = it.next();
        FileInfo info = pair.getValue();
        if (providerId == info.mProvider) {                            
            it.remove();
        }
    }
}