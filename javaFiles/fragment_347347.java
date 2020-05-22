public void setInsects() {

    // Here adapter is the Adapter for the RecyclerView

    adapter.setAdapterList(isDefaultInsectTypes.get‌​InsectNamesList());
    // notifyDataSetChanged() is important here because without this the Adapter has no idea
    // that data has changed.
    adapter.notifyDataSetChanged();
}