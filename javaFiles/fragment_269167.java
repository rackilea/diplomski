@Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        if (getViewType(position) == VIEW_TYPE_MARKET_FEED) {
                bindMarketFeedItemView((MarketFeedViewHolder) viewHolder, position - position / 6);
        }  else {
            bindAdItemView((AdViewHolder) viewHolder);
        }
    }