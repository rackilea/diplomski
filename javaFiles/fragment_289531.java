class Delegate {
    @SuppressWarnings("unused")
    public String handleMessage(String input) {
        called.set(true);
        return "processed" + input;
    }
}

adapter.setDelegate(new Delegate());