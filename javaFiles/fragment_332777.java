private static void disable(ViewGroup layout) {
    layout.setEnabled(false);
    for (int i = 0; i < layout.getChildCount(); i++) {
        View child = layout.getChildAt(i);
        if (child instanceof ViewGroup) {
            disable((ViewGroup) child);
        } else {
            child.setEnabled(false);
        }
    }
}