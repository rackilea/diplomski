private void createRecyclerView(List<DeviceWifiTo> list) {
   RecyclerView recyclerView = activity.findViewById(R.id.recycler_view_wifi);
   recyclerView.setLayoutManager(new LinearLayoutManager(activity.getApplicationContext()));
   WifiAdapter adapter = new WifiAdapter(list);
   recyclerView.setAdapter(adapter);

}