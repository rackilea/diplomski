rv = (RecyclerView) view.findViewById(R.id.list_view_m);
rv.setHasFixedSize(true);
//set a vertical layout so the list is displayed top down
final LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
rv.setLayoutManager(layoutManager);

//initialize the data before binding it to the Adapter
InitData();
mAdapter = new DataAdapter(list, getContext());
rv.setAdapter(mAdapter);