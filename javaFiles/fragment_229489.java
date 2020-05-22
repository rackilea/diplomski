public View findByIdRecursively(View view, int targetId) {
    View result = view.findViewById(targetId);
    if (result != null) {
        return result;
    }
    View parent = (View) view.getParent();
    if (parent == null) {
        return null;
    }
    return findByIdRecursively(parent, targetId);
}