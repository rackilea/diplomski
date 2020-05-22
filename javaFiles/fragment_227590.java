/**
     * Returns a current view attached to the presenter or null.
     *
     * View is normally available between
     * {@link Activity#onResume()} and {@link Activity#onPause()},
     * {@link Fragment#onResume()} and {@link Fragment#onPause()},
     * {@link android.view.View#onAttachedToWindow()} and {@link android.view.View#onDetachedFromWindow()}.
     *
     * Calls outside of these ranges will return null.
     * Notice here that {@link Activity#onActivityResult(int, int, Intent)} is called *before* {@link Activity#onResume()}
     * so you can't use this method as a callback.
     *
     * @return a current attached view.
     */
    @Nullable
    public View getView() {
        return view;
}