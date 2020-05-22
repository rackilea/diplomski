private static ViewGroup findSuitableParent(View view) {
    ViewGroup fallback = null;
    do {
        if (view instanceof CoordinatorLayout) {
            // We've found a CoordinatorLayout, use it
            return (ViewGroup) view;
        } else if (view instanceof FrameLayout) {
            if (view.getId() == android.R.id.content) {
                // If we've hit the decor content view, then we didn't find a CoL in the
                // hierarchy, so use it.
                return (ViewGroup) view;
            } else {
                // It's not the content view but we'll use it as our fallback
                fallback = (ViewGroup) view;
            }
        }

        if (view != null) {
            // Else, we will loop and crawl up the view hierarchy and try to find a parent
            final ViewParent parent = view.getParent();
            view = parent instanceof View ? (View) parent : null;
        }
    } while (view != null);

    // If we reach here then we didn't find a CoL or a suitable content view so we'll fallback
    return fallback;
}