public static void animateLayoutChanges(ViewGroup container) {
    final LayoutTransition transition = new LayoutTransition();
    transition.setDuration(300);

    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
        transition.enableTransitionType(LayoutTransition.CHANGING);
        transition.enableTransitionType(LayoutTransition.APPEARING);
        transition.enableTransitionType(LayoutTransition.CHANGE_APPEARING);
        transition.enableTransitionType(LayoutTransition.DISAPPEARING);
        transition.enableTransitionType(LayoutTransition.CHANGE_DISAPPEARING);
    }

    container.setLayoutTransition(transition);
}