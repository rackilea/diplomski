@Override
public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    if (holder.getItemViewType() == POSTER) {
    final PosterSliderHolder posterViewHolder = (PosterSliderHolder) holder;
    //your logic for sliding item (horizontal recyclerview )
    }
    else{
    final GroupViewHolder groupViewHolder = (GroupViewHolder) holder;
     //normal list item
    }
 }