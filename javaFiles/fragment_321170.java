ArrayList<Places> list = new ArrayList<>();
list = Disco.initDiscoList(list);
PlacesAdapter adapter = new PlacesAdapter(getActivity(), list);
View view = inflater.inflate(R.layout.row_item, container, false);
ListView listView = (ListView) view.findViewById(R.id.list_items);
listView.setAdapter(adapter);

return view;
}