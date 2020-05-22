@Override
    public CardViewDataAdapter_smiley.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                                    int viewType) {
        // create a new view
        context = parent.getContext();
        View itemLayoutView = LayoutInflater.from(context).inflate(
                R.layout.cardview_smiley, null);

        // create ViewHolder

        ViewHolder viewHolder = new ViewHolder(itemLayoutView);
        return viewHolder;
    }