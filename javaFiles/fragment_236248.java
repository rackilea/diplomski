@Override
 public void onBindViewHolder(ViewHolder holder, int position) {

        Log.d(TAG, "onBindViewHolder called");        
        ContentItem item = mContentItems.get(position);

        if(item.getName()!=null){
             holder.textName.setVisibility(View.Visible);
             holder.textName.setText(item.getName());        
        }else{
             holder.textName.setVisibility(View.GONE);
        }

       if(item.getPreviewImageDefault()!=null){
             holder.imageIcon.setVisibility(View.Visible)        
             Picasso.with(mContext).load("file://" + item.getPreviewImageDefault()).into(holder.imageIcon);  
       }else{
             holder.imageIcon.setVisibility(View.GONE)
       }
 }