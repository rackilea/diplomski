public class ViewHolder extends RecyclerView.ViewHolder{
    public TextView tv_country;
    public ViewHolder(View view) {
        super(view);
        tv_country = (TextView) view.findViewById(R.id.tv_country);
    }
}