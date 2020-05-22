@Override
public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
    Object item = collection.get(position);
    int adapterPosition = holder.getAdapterPosition();

    if (holder.getItemViewType() == VIEW_TYPE_TIDUR){
        Story story = (Story) item;
        tidurViewHolder vh = (tidurViewHolder) holder;
        vh.bind(story);
        vh.setViewData(story, adapterPosition);
    } else if (holder.getItemViewType() == VIEW_TYPE_YUKUL){
        YukulModel yukul = (YukulModel) item;
        yukulViewHolder vh = (yukulViewHolder) holder;
        vh.bind(yukul);
        vh.viewDataYukul(yukul, adapterPosition);
    } else if (holder.getItemViewType() == VIEW_TYPE_HOME){
        HomeModel home = (HomeModel) item;
        homeViewHolder vh = (homeViewHolder) holder;
        vh.bind(home);
        vh.viewDataHome(home, adapterPosition);
    }
}