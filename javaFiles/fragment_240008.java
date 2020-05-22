ImageLoader imageLoader = ImageLoader.getInstance();
imageLoader.init(ImageLoaderConfiguration.createDefault(this));

list.setOnScrollListener(new PauseOnScrollListener(imageLoader, false, true) {

    @Override
    public void onScroll(AbsListView view, int firstItem, int itemsInScreen, int totalItems) {
         super.onScroll(view, firstItem, itemsInScreen, totalItems);

         int lastItemInScreen = firstItem + itemsInScreen;
         if (lastItemInScreen == totalItems) {
             //load more items in your listview
         }
     });