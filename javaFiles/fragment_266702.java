public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
public int lastCheckedPosition = -1;

private static OnRecyclerViewItemClickedListener recyclerViewItemClickedListener;

public void setOnRecyclerViewClickedListener (OnRecyclerViewItemClickedListener l) {
recyclerViewItemClickedListener = l;
}

public interface OnRecyclerViewItemClickedListener {
  void OnRecyclerViewItemClicked(int position);
  void OnRecyclerViewItemBind(ViewHolder holder, int position);
  int OnRecyclerViewItemCount();

}
public Adapter() {
  super();
} 

@Override
public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
  View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.table_item_empty, parent, false);
  return new ViewHolder(v);
}

@Override
public void onBindViewHolder(ViewHolder holder, int position) {
recyclerViewItemClickedListener.OnRecyclerViewItemBind(holder,position);
}

@Override
public int getItemCount() {
  return recyclerViewItemClickedListener.OnRecyclerViewItemCount();
}

public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

public TextView txt_no_table;

public ViewHolder(View itemView) {
    super(itemView);
    itemView.setOnClickListener(this);

    txt_no_table = (TextView) itemView.findViewById(R.id.txt_no_table_empty);
}

@Override
public void onClick(View itemView) {

    recyclerViewItemClickedListener.OnRecyclerViewItemClicked(getAdapterPosition());
     }
   }
}