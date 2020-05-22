final AtomicInteger count = new AtomicInteger();

StatusListener listener = new StatusListener() {
    @Override
    public void onStatus(Status status) {
        count.getAndIncrement();
    }

    // omitted...
}

twitterStream.addListener(listener);
twitterStream.filter(fq);

// wait (to allow statuses to be received) then halt the steam...

System.out.println("received " + count.get() + "statuses in total");