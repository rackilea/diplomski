@Override public void onBindViewHolder(ViewHolder holder, int position) {
    holder.bind(items.get(position), listener);
}

public void bind(final ContentItem item, final OnItemClickListener listener) {
    ...
    itemView.setOnClickListener(new View.OnClickListener() {
        @Override public void onClick(View v) {
            listener.onItemClick(item);
        }
    });
}