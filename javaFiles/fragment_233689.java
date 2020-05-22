final HashComparative comp = new HashComparative(enteredHash, lengthOfPass);
comp.addObserver(new Observer() {
    @Override
    public void update(final Observable o, final Object arg) {
        HashComparative hc = (HashComparative)o;
        hash.setText(hc.getHash());
    }
});