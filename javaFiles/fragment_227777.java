@Override
public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    if (holder instanceof ViewHolder) {
         // bind row items items

    }
    // create a separate viewholder class for header
    else if( holder instanceof ViewHolder_header){ 
        // bind header item
    }