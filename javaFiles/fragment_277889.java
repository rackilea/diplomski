public class NestedFragment extends Fragment implements Observer {
    private boolean listUpdated = false; // init the update checking value
    ...
    // setup the listview and the list adapter
    ...
    // use onResume to filter the list if it's not already done
    @Override
    public void onResume() {
        super.onResume();
        // get the filter value
        final String query = MainActivity.getFilterManager().getQuery();
        if (listview != null && adapter != null 
                     && query != null && !listUpdated) {
            // update the list with filter value
            listview.post(new Runnable() {
                @Override
                public void run() {
                    listUpdated = true; // set the update checking value
                    adapter.getFilter().filter(query);
                }
            });
        }
    }
    ...
    // automatically triggered when setChanged() and notifyObservers() are called
    public void update(Observable obs, Object obj) {
        if (obs instanceof FilterManager) {
            String result = ((FilterManager) obs).getQuery(); // retrieve the search value
            if (listAdapter != null) {
                listUpdated = true; // set the update checking value
                listAdapter.getFilter().filter(result); // filter the list (with #2)
            }
        }
    }
}