// Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public CardView mCardView;
        private TextView mchapter_tile;
        private TextView mchapter_detail;
        public ViewHolder(View itemview) {
            super(itemview);

            mCardView = itemView.findViewById(R.id.cv);
            mchapter_tile = itemview.findViewById(R.id.chapter_title);
            mchapter_detail = itemview.findViewById(R.id.chapter_detail);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(List<chapter_title> myDataset) {
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        ViewHolder vh = null;
        View view = (View) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.stack_question_2, parent, false);
        vh = new ViewHolder(view);
        return vh;
    }


    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        final chapter_title chapter_title = mDataset.get(position);
        holder.mchapter_tile.setText(chapter_title.title);
        holder.mCardView.setTag(position);

        if (chapter_title.isExpanded)
            holder.mchapter_detail.setVisibility(View.VISIBLE);
        else
            holder.mchapter_detail.setVisibility(View.GONE);

        holder.mCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(mDataset.get(position).isExpanded)
                {
                    mDataset.get(position).isExpanded = false;
                    ((CardView)v).findViewById(R.id.chapter_detail).setVisibility(View.GONE);
                }
                else
                {
                    ((CardView)v).findViewById(R.id.chapter_detail).setVisibility(View.VISIBLE);
                    mDataset.get(position).isExpanded = true;
                }
                //notifyDataSetChanged();
                notifyItemChanged(position);
            }
        });


    }

    @Override
    public int getItemViewType(int position)
    {
        //  Log.e("getItemType, position", position+"");
        if(mDataset.get(position).isExpanded==true)
            return 1;
        else
            return 0;
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        //      Log.e("list size", mDataset.size()+"");
        return mDataset.size();
    }
}