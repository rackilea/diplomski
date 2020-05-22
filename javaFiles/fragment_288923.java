@Override
public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
    Object item = collection.get(position);

    if (holder.getItemViewType() == VIEW_TYPE_TIDUR){
        ((tidurViewHolder) holder).bind((Story) item);
    } else if (holder.getItemViewType() == VIEW_TYPE_YUKUL){
        ((yukulViewHolder) holder).bind((YukulModel) item);
    } else if (holder.getItemViewType() == VIEW_TYPE_HOME){
        ((homeViewHolder) holder).bind((HomeModel) item);
    }
}