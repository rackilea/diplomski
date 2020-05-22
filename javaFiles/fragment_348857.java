@Override
public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
    ...
    ((ListViewHolder) holder).buttonDelete.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View view){
            removeItem(holder.getAdapterPosition());
        }
    });
}