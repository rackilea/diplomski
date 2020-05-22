@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

      View view = inflater.inflate(R.layout.fragment_find,container,false);

        String [] cinemas={"Cinema 1","Cinema 2","Cinema 3"};
        ArrayAdapter<String> adapter=new ArrayAdapter<>(getActivity(),android.R.layout.simple_list_item_1,cinemas);

        ListView list=(ListView) view.findViewById(R.id.cinema_list);
        list.setAdapter(adapter);

        return view;

    }