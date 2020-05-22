@Override
public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.library, parent, false); //Change the name from v to view

    ListView lvLibList = (ListView)view.findViewById(R.id.lvLibList);
    ImageButton btn = (ImageButton)view.findViewById(R.id.btAddItem);
    EditText edit = (EditText)view.findViewById(R.id.eAddItem);   //Initialize the EditText outside of the click method

    adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, list);

    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            list.add(edit.getText().toString());
            edit.setText("");
            adapter.notifyDataSetChanged();
        }
    };
    btn.setOnClickListener(listener);
    lvLibList.setAdapter(adapter);
    return view;
}