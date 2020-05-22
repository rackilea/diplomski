Window window = getDialog().getWindow();
FrameLayout content = (FrameLayout) window.findViewById(android.R.id.content);

// Make the popup fill at least 4/5 of the screen's width
int minWidth = width*4/5;
content.setMinimumWidth(minWidth);