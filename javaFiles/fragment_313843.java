@Override
public Component.BaselineResizeBehavior getBaselineResizeBehavior() {
    return Component.BaselineResizeBehavior.CONSTANT_ASCENT;
}

@Override
public int getBaseline(int width, int height) {
    return 0;
}