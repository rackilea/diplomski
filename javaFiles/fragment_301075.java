TinyDB tinydb;
    ArrayList<String> mylist = new ArrayList<>();

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        tinydb = new TinyDB(getActivity().getApplicationContext());
        mylist = tinydb.getListString("income");
        LinearLayout m_ll = (LinearLayout) view.findViewById(R.id.home);

        for (int i=0;i<mylist.size();i++) {
            m_ll.addView(createNewTextView(mylist.get(i)));
        }


        return m_ll;
    }

    private TextView createNewTextView(String text) {
        final LinearLayoutCompat.LayoutParams lparams = new LinearLayoutCompat.LayoutParams(LinearLayoutCompat.LayoutParams.WRAP_CONTENT, LinearLayoutCompat.LayoutParams.WRAP_CONTENT);
        final TextView textView = new TextView(getActivity());
        textView.setLayoutParams(lparams);
        textView.setText("New text: " + text);
        return textView;
    }
}