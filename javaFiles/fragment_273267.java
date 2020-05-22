browser.addListener(SWT.KeyDown, new Listener() {
    public void handleEvent(Event event) {
        System.out.println(event.character);
    }
});

display.addFilter(SWT.KeyDown, new Listener() {
    public void handleEvent(Event event) {
        if(event.widget instanceof Browser) {
            event.character = 'l';
        }
    }
});