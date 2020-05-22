@Override
public void onBindViewHolder(MyViewHolder holder, int position) {



    Task task = TaskList.get(position);
    holder.title.setText(task.getTitle());
    holder.finalComment.setTag(position);

    // You need to save the entered text and then set it in onBindViewHolder
    holder.finalComment.setText(THE TEXT FOR THE EDIT TEXT);

    holder.checkBox.setOnCheckedChangeListener(null);
    holder.checkBox.setChecked(task.isState());

    holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            task.setState(b);
        }
    });

}