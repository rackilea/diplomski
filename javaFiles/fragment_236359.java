public int getActivityPositionX() {
    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
        // On Honeycomb or above we return the left margin
        FrameLayout.LayoutParams contentParams = (FrameLayout.LayoutParams) this.content.getLayoutParams();
        return contentParams.leftMargin;
    } else {
        // On devices below Honeycomb we return the left padding
        return this.content.getPaddingLeft();
    }
}

public int getActivityPositionY() {
    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
        // On Honeycomb or above we return the top margin
        FrameLayout.LayoutParams contentParams = (FrameLayout.LayoutParams) this.content.getLayoutParams();
        return contentParams.topMargin;
    } else {
        // On devices below Honeycomb we return the top padding
        return this.content.getPaddingTop();
    }
}