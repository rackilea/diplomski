/* 
 * Download task. Executed in worker thread.
 */
@Override
protected Void doInBackground() throws MalformedURLException, InterruptedException {
    model.addListener(this); // Add another listener...
    try {
        String src = "https://lh3.googleusercontent.com/l6JAkhvfxbP61_FWN92j4ulDMXJNH3HT1DR6xrE7MtwW-2AxpZl_WLnBzTpWhCuYkbHihgBQ=s640-h400-e365";
        model.setURL(src);
        model.download();
    } catch (IOException ex) {
        System.out.println(ex);
        this.cancel(true);
    }
    return null;
}