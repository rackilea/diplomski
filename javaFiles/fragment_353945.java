@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {
    View rootView = inflater.inflate(R.layout.notes, container, false);
    llNotes=(LinearLayout)rootView.findViewById(R.id.llNotes);
    etNots=(EditText)rootView.findViewById(R.id.etNotes);

    etNotes.setOnClickListener(notesListener);

    return rootView;
}

private OnClickListener notesListener = new OnClickListener() {
    public void onClick(View view) {
        String message=etNotes.getText().toString();

        TextView text = new TextView(getActivity());
        text.setText(message);
        llNotes.addView(text);
    }
};