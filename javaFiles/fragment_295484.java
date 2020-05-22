@Override
public RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){

    View view1 = LayoutInflater.from(context1).inflate(R.layout.recycler_view_items,parent,false);
    return new ViewHolder(view1);
}