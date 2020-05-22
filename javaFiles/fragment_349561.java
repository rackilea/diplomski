public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        if (viewType== Constants.gridV){
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_items,parent,false);
            return new MovieViewHolder(view);
        }else if (viewType==Constants.listV)
        {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.linear_item_view,parent,false);
            return new OtherViewHolder(view);
        }else{
            return null;
        }
    }