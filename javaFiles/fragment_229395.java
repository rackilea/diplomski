@Override
public void onActivityCreated(Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);

    setListAdapter(new ArrayAdapter<String>(getActivity(), R.layout.list_probs,PROBLEMS));

    ListView listView = getListView();
    listView.setTextFilterEnabled(true);

    listView.setOnItemClickListener(new OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> a, View v, int position,
                long id) {
                Intent intent = new Intent(MainFragment.this.getActivity(), ProblemActivity.class);
                startActivity(intent);
                }
    });
}