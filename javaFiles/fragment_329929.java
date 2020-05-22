@Override
public RecyclerViewHolders onCreateViewHolder(ViewGroup parent, int viewType) {
    View layoutView = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.grid_cell, parent, false);
    RecyclerViewHolders holder = new RecyclerViewHolders(layoutView);
    return holder;
}