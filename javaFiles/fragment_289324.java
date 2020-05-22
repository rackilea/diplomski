private Animation mInFromRight;
private Animation mInFromLeft;

public Animation inFromRightAnimation() {
    return mInFromRight;
}

public Animation outToLeftAnimation() {
    return mInFromLeft;
}

@Override
protected void onCreate ( Bundle savedInstanceState ){
    super.onCreate(savedInstanceState);
    mInFromRight = new TranslateAnimation(
        Animation.RELATIVE_TO_PARENT, +1.0f,
        Animation.RELATIVE_TO_PARENT, 0.0f,
        Animation.RELATIVE_TO_PARENT, 0.0f,
        Animation.RELATIVE_TO_PARENT, 0.0f);
    mInFromRight.setDuration(500);

    mInFromLeft = new TranslateAnimation(
        Animation.RELATIVE_TO_PARENT, 0.0f,
        Animation.RELATIVE_TO_PARENT, -1.0f,
        Animation.RELATIVE_TO_PARENT, 0.0f,
        Animation.RELATIVE_TO_PARENT, 0.0f);
    mInFromLeft.setDuration(500);

    //...other oncreate code
}