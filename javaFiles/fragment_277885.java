private static ActivityName instance;
private FilterManager filterManager;

@Override
protected void onCreate(Bundle savedInstanceState) {
    ...
    instance = this;
    filterManager = new FilterManager();
}

public static FilterManager getFilterManager() {
    return instance.filterManager; // return the observable class
}

@Override
public boolean onQueryTextChange(String newText) {
    filterManager.setQuery(newText); // update the observable value
    return true;
}