public void onClickTheButton(View view) {
    unselectall(R.layout.your_layout);
}

public void unselectAll(View view) {
    if(view instanceof ViewGroup) {
        for(int ii = 0 ; ii<(ViewGroup)view.getChildrenCount(); ii++) {
            unselectAll((ViewGroup)view.getChildAt(ii));
        }
    }
    unselect(view);
}