@Override
public ItemViewHolder onCreateViewHolder(ViewGroup viewGroup,int viewType) {

    View itemView;
    if (getItemViewType(i)==1) {
        itemView = LayoutInflater.
                from(viewGroup.getContext()).
                inflate(R.layout.cardlayout, viewGroup, false);

    } else {
        itemView = LayoutInflater.from(viewGroup.getContext()).
                inflate(R.layout.bigcircle, viewGroup, false);
    }

    return new ItemViewHolder(itemView,viewType);
}