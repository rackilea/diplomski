if (position == 0){
        convertView.setPadding(0,8,0,0);
} else if (position == getCount() - 1){
        convertView.setPadding(0,0,0,8);
} else {
        convertView.setPadding(0,0,0,0);
}