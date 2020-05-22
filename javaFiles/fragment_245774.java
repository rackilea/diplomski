@Override
    public void onClick(View v) {
    int position=getAdapterPosition();
    item item=this.items.get(position);
    Intent intent=new Intent (v.getContext(),Main2Activity.class);
    v.getContext().startActivity(intent);
}