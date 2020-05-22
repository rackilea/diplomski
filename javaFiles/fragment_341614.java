public static TestFragment newInstance(Context context) {
    if (fragment = null) {
        fragment = new TestFragment();
        text = context.getResources().getString(R.string.voice_search_label);
    }
    return fragment;
}