@Override
 public void success(JSONParser jsonParser) {
      final JSONParser json = jsonParser;
      **locationData = json.storeJSONData();**
      RecyclerView recyclerView = (RecyclerView) 
      view.findViewById(R.id.locationRecyclerView);
      recyclerView.setHasFixedSize(true);
      recyclerView.setAdapter(locationRecyclerAdapter);
      LinearLayoutManager linearLayoutManager = new 
      LinearLayoutManager(getActivity());
      recyclerView.setLayoutManager(linearLayoutManager);