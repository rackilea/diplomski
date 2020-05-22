LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
layoutManager.setOrientation(LinearLayoutManager.VERTICAL
recyclerview.setLayoutManager(layoutManager);
recyclerview.setHasFixedSize(true);

recyclerviewAdapter adapter = new recyclerviewAdapterAdapter(listdata,getActivity());        

recyclerview.setAdapter(adapter);