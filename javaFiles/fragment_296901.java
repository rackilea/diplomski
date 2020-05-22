public class AdapterAssetList extends RecyclerView.Adapter<AdapterAssetList.ViewHolderAssets> {
private final LayoutInflater layoutInflater;
OnItemClickListener itemClickListener;

Context context;
private ImageLoader imageLoader;

public AdapterAssetList(Context mContext, ArrayList<Asset> assetList) {
    this.context = mContext;
    this.assetList = assetList;
    layoutInflater = LayoutInflater.from(context);
}

@NonNull
@Override
public ViewHolderAssets onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
    View view = layoutInflater.inflate(R.layout.dashboard_asset_childs, viewGroup, false);
    ViewHolderAssets viewHolderAssets = new ViewHolderAssets(view);
    return viewHolderAssets;
}

@Override
public void onBindViewHolder(@NonNull final ViewHolderAssets holder, int position) {
    imageLoader = VolleySingleton.getInstance(context).getImageLoader();
    holder.assetName.setText(assetList.get(position).getName());
    holder.assetValue.setText(withSuffix((long) assetList.get(position).getValue()));
}

@Override
public int getItemCount() {
    if (assetList == null)
        assetList = new ArrayList<>();
    return assetList.size();
}

public void SetOnItemClickListener(final OnItemClickListener mItemClickListener) {
    this.itemClickListener = mItemClickListener;
}

public void removeAt(int position) {
    //subsPlanList.remove(position);
    notifyItemRemoved(position);
    //notifyItemRangeChanged(position, subsPlanList.size());
}

public interface OnItemClickListener {
    public void onItemClick(View view, int position, String id);
}

public class ViewHolderAssets extends RecyclerView.ViewHolder implements View.OnClickListener {
    TextView assetName;
    TextView assetValue;


    public ViewHolderAssets(@NonNull View itemView) {
        super(itemView);
        assetName = itemView.findViewById(R.id.txt_asset_name);
        assetValue = itemView.findViewById(R.id.txt_asset_value);


    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        itemClickListener.onItemClick(v, getAdapterPosition(), "copyright");
    }
}

}