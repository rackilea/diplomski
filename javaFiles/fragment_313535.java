if (convertView == null) {
        if(childPosition==0){
            //first view
            convertView = inflater.inflate(R.layout.comments_create_comment, null);
        }else {
            //second view
            convertView = inflater.inflate(R.layout.comments_expandable_list_child, null);
        }
 }