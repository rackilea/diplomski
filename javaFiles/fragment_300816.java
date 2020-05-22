/**
 * The query option to have the OneDrive service expand out results of navigation properties
 */
private static final String EXPAND_QUERY_OPTION_NAME = "expand";

/**
 * Expansion options to get all children, thumbnails of children, and thumbnails
 */
private static final String EXPAND_OPTIONS_FOR_CHILDREN_AND_THUMBNAILS = "children(select=id, name)";


private final Map<String, String> mQueryOptions = new HashMap<>();


private Callback<ItemList> getItemsCallback(final Context context) {
    return new OneDriveDefaultCallback<ItemList>(context) {
        @Override
        public void success(final ItemList items, final Response response) {
            //mItem = items.itemList.get(0);

            //Do what you want to do

            for(Item item: items.itemList){
              Log.v(TAG, "array:"+item.Id+"--- "+item.Name);
            }
        }

        @Override
        public void failure(final RetrofitError error) {

            //Log.v(TAG, "Item Lookup Error: " + mItemId);

        }
    };
}


public void searchQuery(String query){
    mQueryOptions.put(EXPAND_QUERY_OPTION_NAME, EXPAND_OPTIONS_FOR_CHILDREN_AND_THUMBNAILS);
    mQueryOptions.put("q", query);

    final IOneDriveService oneDriveService = oneDriveHelper.getOneDriveService();
    final Callback<ItemList> itemCallback = getItemsCallback(app);
    oneDriveService.searchForItemId(mItemId, mQueryOptions, itemCallback);

}