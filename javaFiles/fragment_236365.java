// These are the LayoutParams for the menu Fragment
FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(width, ViewGroup.LayoutParams.MATCH_PARENT);

// We put a top margin on the menu Fragment container which is equal to the status bar height
params.setMargins(0, statusBarHeight, 0, 0);
menuContainer.setLayoutParams(fragmentParams);