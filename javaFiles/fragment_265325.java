viewHolder.btn_scan.setTag(viewHolder);
viewHolder.btn_scan.setOnClickListener(new OnClickListener(){
            public void onClick(View v){
               ViewHolder selectedViewHolder=(ViewHolder)v.getTag();
               selectedViewHolder.registered_tag.setVisibility(View.VISIBLE);
               ...
            }
        });