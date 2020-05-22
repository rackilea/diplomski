public class HorizontalAdapter extends RecyclerView.Adapter<HorizontalAdapter.HorizontalViewHolder> {

private int[] items;

public HorizontalAdapter(String[] int) {

    this.items = items;

}

@Override
public HorizontalViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    LayoutInflater inflater = LayoutInflater.from(parent.getContext());
    View view = inflater.inflate(R.layout.item_layout_recycler_view_top_10, parent, false);
    return new HorizontalViewHolder(view);
}

@Override
public void onBindViewHolder(HorizontalViewHolder holder, int position) {
    holder.image.setImageResource(items[position]);
}

@Override
public int getItemCount() {
    return items.length;
}

public class HorizontalViewHolder extends RecyclerView.ViewHolder {
    ImageView image;

    public HorizontalViewHolder(View itemView) {
        super(itemView);
        image = itemView.findViewById(R.id.imageviewid);
   } }
}