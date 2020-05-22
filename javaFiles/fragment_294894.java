@Override
public void onBindViewHolder(final myViewHolder viewHolder, int position) {

    if(viewHolder.getAdapterPosition()==currentItem){
        viewHolder.expand();
    } else {
        viewHolder.collapse();
    }
 
    viewHolder.lytHeader.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (currentItem != viewHolder.getAdapterPosition()) {
                currentItem = viewHolder.getAdapterPosition();            
            }
            notifyDataSetChanged();
        }
    });
}