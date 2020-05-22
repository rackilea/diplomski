String val = ((GridView)parent).getAdapter().getItem(position).toString();
LinearLayout ll = (LinearLayout)gridView.findViewById(R.id.item_container); // add this id in your xml
if(val.length() == 0)
    ll.setBackgroundResource(R.color.transparent);
else
    ll.setBackgroundResource(R.drawable.buttons_background);