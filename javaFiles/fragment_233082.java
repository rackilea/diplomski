@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View rootView = inflater.inflate(R.layout.fragment_phone_messages, container, false);

    lvMsgList = (ListView) rootView.findViewById(R.id./*listview*/);

    // Create Inbox box URI
    Uri inboxURI = Uri.parse("content://mms-sms/conversations");
    // Fetch Inbox SMS Message from Built-in Content Provider
    Cursor a = getActivity().getContentResolver().query(inboxURI, new String[]{"*"}, null, null, "normalized_date desc");
    // Attach Cursor with adapter and display in listView
    adapter1 = new SimpleCursorAdapter(getActivity().getApplicationContext(), R.layout.row, a,
            new String[]{"body", "date", "address", "thread_id"},
            new int[]{R.id.lblMsg, R.id.lblDate, R.id.lblNumber, R.id.lblID}, 0);
    lvMsgList.setAdapter(adapter1);
    //set OnItemClickListener for listView, start ConvListActivity
    lvMsgList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            TextView TVConvID = (TextView) view.findViewById(R.id.lblID);
            String ConvID = TVConvID.getText().toString();
            Intent i = new Intent(getActivity(), ConvListActivity.class);
            i.putExtra("CID", ConvID);
            startActivity(i);
        }
    });
    getActivity().setTitle("Phone Messages");

    return rootView;
}