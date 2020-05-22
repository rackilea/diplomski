public ClusterManager.OnClusterItemClickListener<MyItem> mClusterItemClickListener = new ClusterManager.OnClusterItemClickListener<MyItem>() {

    @Override
    public boolean onClusterItemClick(MyItem item) {
        if (item.getTag().equals("SomeValue")) {
            //Do something!
        }
        return true;
    }
};