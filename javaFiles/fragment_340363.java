@Override
public Object instantiateItem(ViewGroup collection, final int position) {

    LayoutInflater inflater = LayoutInflater.from(mContext);
    View layout = inflater.inflate(R.layout.chat_layout, collection, false);

    RecyclerView recyclerView = (RecyclerView) layout.findViewById(R.id.list);
    recyclerView.setLayoutManager(new LinearLayoutManager(mContext));


    AdView mAdView = (AdView) layout.findViewById(R.id.adView);
    AdRequest adRequest = new AdRequest.Builder().build();
    mAdView.loadAd(adRequest);

}