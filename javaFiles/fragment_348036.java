@Override
public View getView(int position, View convertView, ViewGroup parent) {
    RowBeanHolder holder = new RowBeanHolder();
    RowBean rowBean = data.get(position);
    if(convertView == null){
        convertView = inflater.inflate(R.layout.all_object_holder,null);
    }
    holder.txtTitle = (TextView) convertView.findViewById(R.id.showText);
    holder.selected = (CheckBox) convertView.findViewById(R.id.checkBox12);
    if(rowBean != null) {
        holder.txtTitle.setText(rowBean.getTitle());
        holder.selected.setChecked(rowBean.isSelected());
    }

    return convertView;
}