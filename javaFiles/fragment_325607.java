public void setActionBarVisibility(boolean visible) {
    View view = findViewById(R.id.include_action_bar);
    if (view != null) {
        if (visible) {
            view.setVisibility(View.VISIBLE);
        }
        else {
            view.setVisibility(View.GONE);
        }
    }
}