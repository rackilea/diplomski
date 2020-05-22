class MyViewHolder extends RecyclerView.ViewHolder{
    TextView field1,field2;
    LinearLayout layout;

    public MyViewHolder(View itemView) {
        super(itemView);
        field1 = (TextView) itemView.findViewById(R.id.field1);
        field2 = (TextView) itemView.findViewById(R.id.field2);
        layout = itemView.findViewById(R.id.LL_background);
    }
}