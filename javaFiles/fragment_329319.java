// declaring resources
int mHeight;
int mWidth;
/* I am considering a TextView, if you want,
 * you can apply it for any widget you like. */
TextView mTextView = (TextView)findViewById(R.id.your_textview_id);

/* right. now we want to get the screen dimensions. */
Display mDisplay = getWindowManager().getDefaultDisplay();
mHeight = mDisplay.getHeight();
mWidth = mDisplay.getWidth();

/* now we have the values that needed.
 * the next thing to do is mathematical operation.
 * do this as you wish. the thing I do is obtain a
 * value that the mHeight is subtracted by mWidth and divided by 2. */
float mTextSize = (float) (mHeight - mWidth) / 2;

// apply it as text size of the TextView.
mTextView.setTextSize(mTextSize);