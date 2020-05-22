@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {
    // ...

    Button b = (Button) rootView.findViewById(R.id.button1);
    b.setOnClickListener(mButtonClickListener);
    return rootView;
}

private OnClickListener mButtonClickListener = new OnClickListener() {
    public void onClick(View v) {
        addTaskNow();
    }
}