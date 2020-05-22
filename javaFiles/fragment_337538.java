public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {

    View view = inflater.inflate(R.layout.fragment_fichas, container, false);


    //It's not in the Activity layout:
    //mList = (ListView) getActivity().findViewById(R.id.list);

    //It's in the Fragment layout:
    mList = (ListView) view.findViewById(R.id.list);

    urgentTodosAdapter = new CustomAdapter(getActivity());
    mList.setAdapter(urgentTodosAdapter);
    urgentTodosAdapter.loadObjects();


    return view;

}