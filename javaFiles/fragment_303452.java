public View getView(int position, View convertView, ViewGroup parent) {
    ViewHolder holder;
    ...
    holder.textView.setText(jsonTexts[position]);
    ...

    return convertView;
}