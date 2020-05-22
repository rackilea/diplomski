if (convertView == null){
            ....
            convertView.setTag(holder);
     } else {
           holder = (ViewHolder) convertView.getTag(); 
      }