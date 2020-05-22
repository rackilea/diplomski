viewHolder.checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
 @Override
  public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {
     if(isChecked)
      {
        if(list.getCount() > position)
        {
        list.remove(position);
        this.notifyDataSetChanged();
        }
      }
     else
     {
       Log.e("CheckBox", isChecked+"");
     }
   }
 });