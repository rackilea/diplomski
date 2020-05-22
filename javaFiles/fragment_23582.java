public static final Handler handlerVisibility = new Handler() {
    public void handleMessage(Message msg) {
        int visibility = msg.getData().getInt("visibility");
        view.setVisibility(visibility);
    }
};