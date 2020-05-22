public void setTitle(String title) {
    _title = title;
    _proxyAdapter.clear();
    _proxyAdapter.add(title);
    setSelection(0);
}