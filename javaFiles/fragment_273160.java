public <T> List<T>  getViewsByClass(View rootView, Class<T> targetClass) {
    List<T> items = new ArrayList<>();
    getViewsByClassRecursive(items,rootView,targetClass);
    return items;
}

private void getViewsByClassRecursive(List items, View view, Class clazz) {
    if (view.getClass().equals(clazz)) {
        Log.d("TAG","Found " + view.getClass().getSimpleName());
        items.add(view);
    }

    if (view instanceof ViewGroup) {
        ViewGroup viewGroup = (ViewGroup)view;
        if (viewGroup.getChildCount() > 0) {
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                getViewsByClassRecursive(items, viewGroup.getChildAt(i), clazz);
            }
        }
    }
}