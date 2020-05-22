viewHolder.rb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if(isChecked) {
                if(!isFirstTime) {
                    YouDialogHoldingClass.itemSelected(position);
                }
                else {
                   isFirstTime = false;
                }
                //selectedItem = position;
                //notifyDataSetChanged();
            }
        }
    });

    if(position == selectedItem) {
        isFirstTime = true;
        viewHolder.rb.setChecked(true);
    } else {
        viewHolder.rb.setChecked(false);
    }
    return convertView;