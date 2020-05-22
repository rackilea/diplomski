@NonNull
@Override
public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    RecyclerView.ViewHolder vh;
    if (viewType == VIEW_ITEM) {
        vh = makeViewHolder();
    } else {
        View v = LayoutInflater.from(context).inflate(R.layout.loading_row, parent, false);
        vh = new ProgressViewHolder(v);
    }
    return vh;
}