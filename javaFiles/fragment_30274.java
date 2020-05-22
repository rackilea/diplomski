@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {
    View rootView = inflater.inflate(R.layout.fragment_diseases_main, container, false);

    data = DataProviderDiseases.getData();

    ArrayAdapter<Diseases> diseasesArrayAdapter= new ArrayAdapter<Diseases>(getActivity(), android.R.layout.simple_list_item_1, data);
    ListView listView = (ListView) rootView.findViewById(android.R.id.list);
    listView.setAdapter(diseasesArrayAdapter);

    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Diseases diseases = data.get(position);
            displayDetail(diseases);
        }
    });

     return rootView; // It must be here
}