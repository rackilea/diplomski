if (convertView == null) {
        convertView = mInflater.inflate(R.layout.list_entry, null);
        holder = new ViewHolder(convertView);
        convertView.setTag(holder);
    }
    else {
        holder = (ViewHolder) convertView.getTag();
    }
    holder.city.setText(listModel.get(position).getCity());
    holder.name.setText(listModel.get(position).getName);
    return convertView;
}