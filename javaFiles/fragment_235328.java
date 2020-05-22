private void setSelectedItem(int position) {
    for(int i = 0; i < selectedItems.length(); i++) {
        if(i == position) selectedItems[i] = 1;
        else selectedItems[i] = 0;
    }
} 

itemView.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        if (listener != null) {
            int position = getAdapterPosition();
            if (position != RecyclerView.NO_POSITION) {
                setSelectedItem(position);
                notifyDataSetChanged();
            }
        }
    }
});