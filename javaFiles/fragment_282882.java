public void registerDownloadListener(DownloadListener downloadListener) {
    mDownloadListeners.add(downloadListener);
}

...

public boolean handleMessage(Message msg) {
    if (msg.what != 29) {
        return false;
    }

    for (DownloadListener listener : mDownloadListeners) {
        listener.onDownloaded();
    }

    return true;
}