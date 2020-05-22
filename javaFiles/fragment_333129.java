class ItemAdapter extends RecyclerView.Adapter{

ArrayList<Item> items;

ItemAdapter(ArrayList<Item> items) { this.items = items }

@Override
public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View view = inflater.inflate(R.layout.custom_row, parent, false);
    return new MyViewHolder(view);
}

@Override
public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
    holder.toggleButton.setChecked(items.get(position).getToggleOn());
}

@Override
public int getItemCount() {
    return items.size();
}

void toggleItemOn(int position){
items.get(position).setToggleOn(true);
notifyDataSetChanged();
}

}