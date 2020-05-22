public void setActivityPosition(int x, int y) {
    // With this if statement we can check if the devices API level is above Honeycomb or below
    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
        // On Honeycomb or abvoe we set a margin
        FrameLayout.LayoutParams contentParams = (FrameLayout.LayoutParams) this.content.getLayoutParams();
        contentParams.setMargins(x, y, -x, -y);
        this.content.setLayoutParams(contentParams);
    } else {
        // And on devices below Honeycomb we set a padding
        this.content.setPadding(x, y, -x, -y);
    }
}