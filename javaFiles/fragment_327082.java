@Override 
public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
    try {
        final GridViewHolder viewHolder = (GridViewHolder) holder;

        viewHolder.myCheckBox.setTag(position);

        //add this two lines 
        viewHolder.myCheckBox.setOnCheckedChangeListener(null);
        viewHolder.myCheckBox.setChecked(items.get(position).isChecked());

        viewHolder.myCheckBox.setOnCheckedChangeListener(new 
            CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton,boolean b) {


                items.get(position).setChecked(b);

                if (items.get(position).isChecked())
                   Count++;
                else
                  Count--;

                if (Count > 0) {
                   ((MyActivity)context).showButton().setEnabled(true);
                } else {
                   ((MyActivity)context).showButton().setEnabled(false);
                }}
        });

    } catch (Exception e) {
        e.printStackTrace();
    }
}