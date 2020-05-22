holder.tvIcon.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent = new Intent("search_engines");
        intent.putExtra("url", url);
        int PreviousSelectedItem = selectedItem;
        selectedItem = i;

        // Set the static value in the MainActivity 
        // This can be accessed from all other classes
        MainActivity.selectedItem = i;

        intent.putExtra("selected", selectedItem);
        holder.tvIcon.setBackgroundColor(Color.parseColor("#30000000"));
        notifyItemChanged(PreviousSelectedItem);
        notifyDataSetChanged();
    }
});