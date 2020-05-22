@Override
protected void init(VaadinRequest request) {
    setPollInterval(1000);
    addPollListener(new UIEvents.PollListener() {
        @Override
        public void poll(UIEvents.PollEvent event) {
            log.debug("Polling");
        }
    });
}