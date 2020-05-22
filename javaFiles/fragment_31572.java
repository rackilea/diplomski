@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {
    LinearLayout rootView = (LinearLayout) inflater.inflate(
            R.layout.fragment_product_list, container, false);

    // LinearLayout ll = new LinearLayout(getActivity());
    rootView.setOrientation(LinearLayout.VERTICAL);
    for (int i = 0; i < 20; i++) {
        CheckBox cb = new CheckBox(rootView.getContext());
        rootView.setLayoutParams(new LayoutParams(
                LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
        cb.setText("check");
        rootView.addView(cb);
    }
    return rootView;
}