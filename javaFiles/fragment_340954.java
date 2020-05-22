if (listViewItemType == TYPE_short) {
  viewHolder.itemTitleView.setText(datas.get(position).itemTitle);      
} else if (listViewItemType == TYPE_med) {
  viewHolder.itemTitleView1.setText(datas.get(position).itemTitle);      
} else if (listViewItemType == TYPE_long) {
  viewHolder.itemTitleView2.setText(datas.get(position).itemTitle);      
}