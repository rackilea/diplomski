@NonNull
@Override
public EventViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
    return new EventViewHolder(view);
}