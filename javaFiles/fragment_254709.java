if (item.get(position).isSection()) {
    //your code...
} else {
    //your code...
    TextView tvItemTitle = (TextView) convertView.findViewById(R.id.textView2);
    tvItemTitle.setText(((EntryItem) item.get(position)).getValue());
}