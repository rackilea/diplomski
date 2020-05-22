@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {
    View rootView = inflater.inflate(R.layout.fragment_main, container, false);

    CalorieDatatabaseManagement db = new CalorieDatatabaseManagement(getActivity());
    ArrayList<HashMap<String, String>> foodList = db.getAllFood();
    if(foodList.size() != 0) {
        ListView listView = (ListView) rootView.findViewById(R.id.foodListView);

        ArrayAdapter<HashMap<String, String>> arrayAdapter = new 
            ArrayAdapter<HashMap<String, String>>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                foodList );
        listView.setAdapter(arrayAdapter);
        return rootView;
    }
}