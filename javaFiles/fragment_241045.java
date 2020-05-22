@Override
public HistoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

    View itemView = LayoutInflater.
            from(parent.getContext()).
            inflate(R.layout.layout_for_single_item, parent, false);

    return new HistoryViewHolder(itemView);
}