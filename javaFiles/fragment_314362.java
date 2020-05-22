public static ArrayList<View> getAllViewsFromRoots(View...roots) {
    ArrayList<View> result = new ArrayList<View>();
    for (View root : roots) {
        getAllViews(result, root);
    }
    return result;
}

private static void getAllViews(ArrayList<View> allviews, View parent) {
    allviews.add(parent);
    if (parent instanceof ViewGroup) {
        ViewGroup viewGroup = (ViewGroup)parent;
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            getAllViews(allviews, viewGroup.getChildAt(i));
        }
    }
}