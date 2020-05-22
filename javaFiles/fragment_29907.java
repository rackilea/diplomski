View myCustomView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // No inflation here..
        LinearLayout linearLayout = new LinearLayout(getActivity());
        // Add a TextView, you can add any other view you want
        linearLayout.addView(new TextView(getActivity()));

        myCustomView = linearLayout;

        return myCustomView ;
    }
}