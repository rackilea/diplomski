@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {
    if (container == null) {
        // We have different layouts, and in one of them this
        // fragment's containing frame doesn't exist.  The fragment
        // may still be created from its saved state, but there is
        // no reason to try to create its view hierarchy because it
        // won't be displayed.  Note this is not needed -- we could
        // just run the code below, where we would create and return
        // the view hierarchy; it would just never be used.
        return null;
    }

    ScrollView scroller = new ScrollView(getActivity());
    TextView text = new TextView(getActivity());
    int padding = (int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
            4, getActivity().getResources().getDisplayMetrics());
    text.setPadding(padding, padding, padding, padding);
    scroller.addView(text);
    text.setText(Shakespeare.DIALOGUE[getShownIndex()]);
    return scroller;
}