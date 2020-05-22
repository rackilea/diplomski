@Override
public void onBindViewHolder(Adapter.MyViewHolder holder, int position) {
    holder.field1.setText(ModelArrayList.get(position).getField1());
    holder.field2.setText(ModelArrayList.get(position).getField2());

    if(ModelArrayList.get(position).getField1().equalIgnoreCase("red")
        holder.layout.setBackgroundColor(Color.RED)
}