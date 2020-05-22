@Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (viewType == VIEW_TITLE) {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.list_expand_title, parent, false);
            return new TitleHolder(itemView);
        } else {
            View itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.row_wallet_history, parent, false);
            return new DataHolder(itemView);
        }
    }