parentlayout.setOnFocusChangeListener(new View.OnFocusChangeListener() {
    @Override
    public void onFocusChange(View view, boolean hasFocus) {
        View viewSelected = getViewSelected();
        // if the selected view exists and it lost focus
        if (viewSelected != null && !viewSelected.hasFocus()) {
            // remove it
            removeViewSelected();
        }
    }
});