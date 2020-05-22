@Override
public void onApplyWindowInsets(WindowInsets insets)
{
super.onApplyWindowInsets(insets);
mIsRound = insets.isRound();
mChinSize = insets.getSystemWindowInsetBottom();
}