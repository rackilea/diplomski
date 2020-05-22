private int selectedIndex = -1;

@Override
public void onBindViewHolder(ViewHolder holder, int position) {
    holder.btn1.setOnClickListener( v -> {
            if (selectedIndex != position) {
                selectedIndex = position;
                notifyDataSetChanged();
            }
        }
    );

    // Change here the background of unselected item
    if (selectedIndex == position) {
        // Change here the background of selected item
    }
}