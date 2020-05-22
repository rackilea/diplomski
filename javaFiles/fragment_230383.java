@Override
public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position, @NonNull List payloads) {
    if (payloads.isEmpty()) onBindViewHolder(holder, position);
    else if ("updateText".equals(payloads.get(0))) {
        if (holder instanceof YourViewHolder) {
            ((YourViewHolder) holder).textView.setText(dataProvider.get(position).getNewText());
        }
    }
}