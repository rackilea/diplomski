API.start(new Callback() {
    public void onReady()
    {
        API.invite(new Callback() {
            public void onReady()
            {
                API.send("hello");
                API.send("What's up");
            }
        });
    }
});