final HashComparative comp = new HashComparative(enteredHash, lengthOfPass);
scheduler.scheduleAtFixedRate(new Runnable() {
    @Override
    public void run() {
        hash.setText(comp.getHash());
    }
}, 1L, 1L, TimeUnit.SECONDS);