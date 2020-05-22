@Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        orderListView = (ListView) view.findViewById(R.id.listViewOrder);
        orderListView.setAdapter(adapter);
  }