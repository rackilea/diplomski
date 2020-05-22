public class ViewHolder {
    private TextView tvName;
    private TextView tvCity;

    public ViewHolder(View view){
        tvCity  =  (TextView) view.findViewById(R.id.tv_item_city);
        tvName  =  (TextView) view.findViewById(R.id.tv_item_name);
    }
}