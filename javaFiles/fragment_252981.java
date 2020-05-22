layout.getViewTreeObserver().addOnTouchModeChangeListener(new ViewTreeObserver.OnTouchModeChangeListener()
{
    public void onTouchModeChanged(boolean isInTouchMode)
    {
        if (!isInTouchMode)
            button.requestFocus();
    }
});