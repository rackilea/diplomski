ViewHolder holder = null;
        NetworkImageView i;
        childPosition = position;

        if (convertView == null) {

        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        convertView.setOnclickListener(new OnClickListener{

          @Override 
          onClick(View v){
      isChecked=child.get(childPosition).isChecked();
         if(!isChecked){
            child.get(childPosition).setChecked(true);
         }
         else {
            child.get(childPosition).setChecked(false);
         }        

      });