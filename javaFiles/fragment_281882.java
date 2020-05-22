public ViewParent findParentRecursively(View view, int targetId) {
    if (view.getId() == targetId) {
        return (ViewParent)view;
    }
    View parent = (View) view.getParent();
    if (parent == null) {
        return null;
    }
    return findParentRecursively(parent, targetId);
}