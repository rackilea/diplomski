public CustomAdapter(Context context) {
        this.context = context;
        for (int i = 0; i < 50; i++) {
            list.add(new Bean("item at " + i));
        }
    }

    @Override
    public Bean getItem(int position) {
        return list.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //Initialization .......

        Bean item = getItem(position);
        holder.tv1.setText(item.name);
        holder.tv2.setText(item.name);
        holder.tv1.setVisibility(item.visibility);
        return convertView;
    }
    // ViewHolder declaration 
    .......
public static class Bean {
    String name;
    int visibility = View.VISIBLE;

    public Bean(String name) {
        this.name = name;
    }
}