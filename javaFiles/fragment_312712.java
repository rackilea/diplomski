private void setBottomMargins (AdView adView, int bottomMargin) {
    if (adView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
      ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) adView.getLayoutParams();
      layoutParams.setMargins(0, 0, 0, bottomMargin);
      adView.requestLayout();
    }
  }