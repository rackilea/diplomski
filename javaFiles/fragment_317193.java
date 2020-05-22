public void onButtonClicked(View view) {
    ViewGroup viewGroup = (ViewGroup) view.getParent();

    for (int i=0; i<viewGroup.getChildCount(); i++) {
        if (viewGroup.getChildAt(i) instanceof CheckBox) {
            if ((CheckBox) viewGroup.getChildAt(i).isChecked()) {
                // do something here
            }
        }
    }
}