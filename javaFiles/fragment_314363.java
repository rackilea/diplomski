public static EditText getEditText(View root) {
    ArrayList<View> views = getAllViewsFromRoots(root);
    for (View view : views) {
        if (view instanceof EditText && view.getVisibility() == View.VISIBLE) {
            return (EditText) view;
        }
    }
    return null;
}