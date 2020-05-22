@Override
protected void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);

    // example saving focused state of overlays
    if (itemizedOverlay.getFocus() != null) outState.putInt("focused_1", itemizedOverlay.getLastFocusedIndex());
    if (itemizedOverlay2.getFocus() != null) outState.putInt("focused_2", itemizedOverlay2.getLastFocusedIndex());
    super.onSaveInstanceState(outState);

}