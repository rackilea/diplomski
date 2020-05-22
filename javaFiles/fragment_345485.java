ViewGroup.LayoutParams layoutParams = aktUIItem.getLayoutParams();

if (layoutParams instanceof FrameLayout.LayoutParams) {
  FrameLayout.LayoutParams frameLayoutParams = (FrameLayout.LayoutParams)layoutParams;
  ...// do that old school logic
}
// ignore layoutParams or do another instance of check.