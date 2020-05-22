final Object lock = new Object();
final LimitedFileWriter output = new LimitedFileWriter("Tweets","tweets");
TwitterStream twitterStream = new TwitterStreamFactory(cb.build()).getInstance();
StatusListener listener = new StatusListener() {
    @Override
    public void onStatus(Status status) {
        try{
        output.write("@" + status.getUser().getScreenName() + " -- " + status.getText()+"\n");
        // free the lock
        if (some_condition_like_I_have_enough_files) {
            synchronized (lock) {
                lock.notify();
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}

twitterStream.addListener(listener);
twitterStream.sample("en");

try {
    synchronized (lock) {
        lock.wait();
    }
} catch (InterruptedException e) {
    e.printStackTrace();
}
// close the twitterstream
// close the writer