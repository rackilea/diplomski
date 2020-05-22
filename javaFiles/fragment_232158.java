ListView listView ;
 public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {

    View rootView = inflater.inflate(R.layout.fragment_attendance_mark, container, false);
    listView = (ListView) rootView.findViewById(R.id.listView1);
 // Generate list View from ArrayList
        displayListView();
        checkButtonClick();
    return rootView;
}