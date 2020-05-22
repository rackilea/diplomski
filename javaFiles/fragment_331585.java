View view = null;

if (viewType == AD_TYPE)
{
    view = new AdView(activity, AdSize.BANNER, ADMOB_ID);
    float density = activity.getResources().getDisplayMetrics().density;
    int height = Math.round(AdSize.BANNER.getHeight() * density);
    AbsListView.LayoutParams params = new AbsListView.LayoutParams(AbsListView.LayoutParams.FILL_PARENT,height);
    view.setLayoutParams(params);
    view.loadAd(new AdRequest());
}
else{
    view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_layout, viewGroup, false);
}

RecyclerView.ViewHolder viewHolder = new RecyclerView.ViewHolder(view);
return viewHolder;