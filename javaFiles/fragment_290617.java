@NonNull
private FrameLayout createSampleFloatingView() {
    MutableContextWrapper mutableContextWrapper = new MutableContextWrapper(getActivity());
    FrameLayout view = new FrameLayout(mutableContextWrapper);
    LayoutInflater layoutInflater = new MyLayoutInflater(mutableContextWrapper);
    LayoutInflaterCompat.setFactory2(layoutInflater, new MyLayoutInflaterFactory(mutableContextWrapper));
    layoutInflater.inflate(R.layout.sample_floating_view, view, true);
    return view;
}