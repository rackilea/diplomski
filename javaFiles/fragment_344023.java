case REST_UPDATE: {
    if (adapter == null || recyclerView.getAdapter() == null) {
        adapter = new adapter(getActivity(), DataStorage.getInstance().getItems());
        recyclerView.setAdapter(adapter);
    } else {
        adapter.swap(DataStorage.getInstance().getItems());
    }
    getActivity().runOnUiThread(new Runnable() {
        @Override
        public void run() {
            adapter.notifyDataSetChanged();
        }
    });
    break;
}