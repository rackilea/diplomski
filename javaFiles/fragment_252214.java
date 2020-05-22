...
@Override
public View getView(int position, View convertView, ViewGroup parent) {
    ...

    TypePoi country = typeList.get(position);
    holder.name.setText(country.getName());
    holder.name.setChecked(country.isSelected());

    // Try inserting this line
    holder.name.setTag(country);

    return convertView;
}