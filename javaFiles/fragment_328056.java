class CustomAdEventListener extends AdEventListener {

    private String id;

    public CustomAdEventListener(String id) {
        this.id = id;
    }

    @Override
    public void onReceiveAd(Ad arg0) {
        // Log your id here
        startAppAd.showAd();
    }
}