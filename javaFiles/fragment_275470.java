class MyHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    ItemObject itemObject;

    public MyHolder(View itemView) {
        super(itemView);
        itemView.findViewById(your button Id).setOnClickListener(this); // make this holder receives the clicks
    }

    @Override
    public void onClick(View view) {
        // here you add logic that depending on the data from itemObject
    }

}