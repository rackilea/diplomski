private void initPlantList(View v){
RecyclerView rV = v.findViewById(R.id.plantsRecycler);
PlantListAdapter pLA = new PlantListAdapter(this);
Log.d("PLA", pLA.hasContext());
rV.setAdapter(pLA);
rV.setLayoutManager(new LinearLayoutManager(this));