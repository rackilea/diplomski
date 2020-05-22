@Override
public void onBindViewHolder(final ViewHolder holder, int position) {
    holder.textViewTitle.setText(data.get(position).title);
    holder.textViewContent.setText(data.get(position).content);

    Context context = holder.button.getContext();    
    holder.button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(context, "you clicked the button!", Toast.LENGTH_SHORT).show();
        }
    });
}