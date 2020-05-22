public class listAdapter extends RecyclerView.Adapter<listAdapter.ViewHolder> {

ArrayList<outletData> outletDataFromFragment;
RecyclerView recyclerView;
Context mContext;

listAdapter(ArrayList<outletData> outletDataFromFragment) {
    this.outletDataFromFragment = outletDataFromFragment;
}


@Override
public listAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
    this.mContext = viewGroup.getContext();
    View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item, viewGroup, false);

    return new ViewHolder(itemView);
}

@Override
public void onBindViewHolder(@NonNull listAdapter.ViewHolder viewHolder, int i) {
    outletData data = outletDataFromFragment.get(i);
    viewHolder.listName.setText(data.getName());
    viewHolder.listDeal.setText(data.getDeals());
    viewHolder.listOffer.setText(data.getOfferPeriod());
    try {
        InputStream ims = mContext.getAssets().open(""+your_image_name);
        Drawable d = Drawable.createFromStream(ims, null);
        viewHolder.listImg.setImageDrawable(d);
        ims.close();
    } catch(IOException ex) {
        return;
    }
}