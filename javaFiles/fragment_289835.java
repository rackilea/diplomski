// Replace the contents of a view (invoked by the layout manager)
@Override
public void onBindViewHolder(ViewHolder holder, int position) {
    // - get element from your dataset at this position
    // - replace the contents of the view with that element

    ProgramViewHolder programViewHolder = (ProgramViewHolder) holder;
    programViewHolder.vName.setOnClicklistener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mainActivity.openSettings(1);
        }
    });

}