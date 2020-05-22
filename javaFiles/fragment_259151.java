@NonNull
@Override
public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    LayoutInflater inflater = LayoutInflater.from(parent.getContext());
    View itemView = inflater.inflate(viewType, parent, false);

    switch (viewType) {
        case R.layout.cardview_a:
            return new CallViewHolder(itemView);

        case R.layout.cardview_b:
            return new SMSViewHolder(itemView);

        default:
            throw new IllegalArgumentException("unexpected viewType: " + viewType);
    }
}