Button button = new Button(this);
// initialize button - text, background, etc
layout.addView(button, new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.WRAP_CONTENT));

ImageView badgeBubble = new ImageView(this);
// initialize badge - source image/drawable, scale type, etc
layout.addView(badgeBubble, new FrameLayout.LayoutParams(FrameLayout.LayoutParams.WRAP_CONTENT, FrameLayout.LayoutParams.WRAP_CONTENT, Gravity.TOP | Gravity.LEFT));