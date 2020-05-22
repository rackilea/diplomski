// Load the image as a NinePatch drawable
NinePatchDrawable npd = (NinePatchDrawable)Resources.getDrawable(R.drawable.my_nine_patch);

// Set its bound where you need
Rect npdBounds = new Rect(...);
npd.setBounds(npbBounds);

// Finally draw on the canvas
npd.draw(canvas);