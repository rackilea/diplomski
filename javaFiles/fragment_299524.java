private View selectedView;

...
private void setViewSelected(View view) {
    removeViewSelected();

    selectedView = view;
    if (selectedView != null) {
        // change to a selected background for example
        selectedView.setBackgroundColor(
                ContextCompat.getColor(this, R.color.colorAccent));
    }
}

private View getViewSelected() {
    if (selectedView != null) {
        return selectedView;
    }
    return null;
}

private void removeViewSelected() {
    if (selectedView != null) {
        // reset the original background for example
        selectedView.setBackgroundResource(R.drawable.white_with_borders);
        selectedView = null;
    }
    // clear and reset the focus on the parent
    parentlayout.clearFocus();
    parentlayout.requestFocus();
}