public class MyItem implements ClusterItem {
    private final LatLng mPosition;
    private final String mTitle;
    private final String mSnippet;
    private final String mTag; // <- This is the tag

    public MyItem(double lat, double lng, String t, String s, String tg) {
        mPosition = new LatLng(lat, lng);
        mTitle = t;
        mSnippet = s;
        mTag = tg;
    }

    @Override
    public LatLng getPosition() {
        return mPosition;
    }

    public String getTitle(){
        return mTitle;
    }

    public String getSnippet(){
        return mSnippet;
    }

    public String getTag(){
        return mTag;
    }
}