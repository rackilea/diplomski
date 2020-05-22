final int currentX = getActivityPositionX();

FrameLayout menuContainer = new FrameLayout(context);

// The width of the menu is equal to the x position of the `Activity`
FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(currentX, ViewGroup.LayoutParams.MATCH_PARENT);
menuContainer.setLayoutParams(params);

ViewGroup parent = (ViewGroup) content.getParent();
parent.addView(menuContainer);