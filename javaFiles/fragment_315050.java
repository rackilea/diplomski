@Override
public void onResume() {
    super.onResume();
    EventBus.getDefault().register(this);
}

@Override
public void onPause() {
    EventBus.getDefault().unregister(this);
    super.onPause();
}

@Subscribe(threadMode = ThreadMode.MAIN)
public void onSearchQuery(SearchQueryEvent event) {
    String query=event.getQuery();
    adapter.getFilter().filter(query);
}