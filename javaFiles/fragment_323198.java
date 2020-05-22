private SlidingUpPanelLayout slidingLayout;

@Ovverride
public void onCreate(Bundle bundle) {
    slidingLayout = (SlidingUpPanelLayout) findViewById(R.id.sliding_layout);

}

@Override
public void onPanelSlide(View panel, float slideOffset) {
    if (lDetails != null) {
        if (!varsInitialized) {
            relativeParams = (RelativeLayout.LayoutParams) lDetails.getLayoutParams();
            varsInitialized = true;
        }
        int adjustedMargin = slidingLayout.getHeight() - slidingLayout.getPanelHeight() - panel.getTop();
        relativeParams.setMargins(0, adjustedMargin, 0, 0);  // left, top, right, bottom
        lDetails.setLayoutParams(relativeParams);
    }
}