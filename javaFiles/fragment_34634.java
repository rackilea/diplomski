public View getView(int position, View convertView, ViewGroup parent){
    ViewHolder holder;
    if(convertView == null){
        // You should fetch the LayoutInflater once in your constructor
        LayoutInflater inflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.list_item_2, null);

        // Initialize ViewHolder here
    }else{
        holder = (ViewHolder) convertView.getTag();
    }

    File file = filesArrayList.get(position);
    holder.text1.setText(file.getTitle());
    holder.text2.setText2(file.getDescription());
    return convertView;
}